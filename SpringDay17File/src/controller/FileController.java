package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Book;

@Controller
public class FileController {
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(Book book){
		ModelAndView mv = new ModelAndView("upload_result");
		
		// 업로드된 파일이 저장될 폴더 경로
		String savePath = "c:/upload/";
		
		File dir = new File(savePath);
		
		if(dir.exists() == false){
			// 만약 폴더가 없다면 만들어라.
			dir.mkdir();
		}
		// 때에 따라서는 사용자가 업로드한 원래 파일이름과 서버에 저장되는 파일 이름이 달라질 수 잇음.
		String savedName = savePath + "/" + book.getMyFile().getOriginalFilename()
							+ new Random().nextInt(1000000);
		File savedFile = new File(savedName);
		
		try {
			// 클라이언트의 파일을 좀전에 만든 공파일에 옮겨담기!
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
			//다운로드해줄 파일 읽어들이는 stream
			is = new FileInputStream("c:/upload/Koala.jpg881130");
			
			//읽어들인 파일을 보낼 response의 Stream
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
}
