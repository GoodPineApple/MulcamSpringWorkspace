package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vo.Book;
import vo.Movie;

@Controller
public class FileController {
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(Book book){
		ModelAndView mv = new ModelAndView("upload_result");
		
		// ���ε�� ������ ����� ���� ���
		String savePath = "c:/upload/";
		
		File dir = new File(savePath);
		
		if(dir.exists() == false){
			// ���� ������ ���ٸ� ������.
			dir.mkdir();
		}
		// ���� ���󼭴� ����ڰ� ���ε��� ���� �����̸��� ������ ����Ǵ� ���� �̸��� �޶��� �� ����.
		String savedName = savePath + "/" + book.getMyFile().getOriginalFilename()
							+ new Random().nextInt(1000000);
		File savedFile = new File(savedName);
		
		try {
			// Ŭ���̾�Ʈ�� ������ ������ ���� �����Ͽ� �Űܴ��!
			book.getMyFile().transferTo(savedFile);
			mv.addObject("originalName", book.getMyFile().getOriginalFilename());
			mv.addObject("savedPath", savedName);
			mv.addObject("title", book.getTitle());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response){
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment); filename=\"Koala.jap\"");
		FileInputStream is = null;
		ServletOutputStream os = null;
		
		try {
			//�ٿ�ε����� ���� �о���̴� stream
			is = new FileInputStream("c:/upload/Koala.jpg881130");
			
			//�о���� ������ ���� response�� Stream
			os = response.getOutputStream();
			
			byte[] buf = new byte[1024];
			int size = 0;
			
			while((size = is.read(buf)) != 0){
				os.write(buf,0,size);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/movie.do")
	public String uploadMovieForm(){
		return "upload_form_movie";
	}
	
	@RequestMapping(value="/uploadMovie.do", method=RequestMethod.POST)
	public ModelAndView uploadMovie(Movie movie){
		ModelAndView mv = new ModelAndView("upload_movie_result");
		
		// ���ε�� ������ ����� ���� ���
		String savePath = "c:/upload_movie/";
		
		File dir = new File(savePath);
		
		if(dir.exists() == false){
			// ���� ������ ���ٸ� ������.
			dir.mkdir();
		}
		
		for(MultipartFile f:movie.getMyFile()){
			String savedName = savePath + "/" + f.getOriginalFilename()
			+ new Random().nextInt(1000000);
			File savedFile = new File(savedName);
			
			try {
				f.transferTo(savedFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�����̸� : " + f.getOriginalFilename());
			System.out.println("������̸� : " + savedName);
			System.out.println("=================================");
		}
		mv.addObject("uploadFileNames", movie.getMyFile());
		return mv;
	}
	
	// ���ε�� ������ ���� ������Ʈ ���� ������ ����ǰ� �ϰ� ������ ���� �����θ� �Ʒ��� ���� �ϸ��
	public ModelAndView uploadMovie(HttpServletRequest req, Movie movie){
		String savePath = req.getServletContext().getRealPath("img");
		return null;
	}
}