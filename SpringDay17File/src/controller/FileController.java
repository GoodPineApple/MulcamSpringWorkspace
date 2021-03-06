package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
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
	public String uploadForm() {
		return "upload_form";
	}

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public ModelAndView upload(Book book) {
		ModelAndView mv = new ModelAndView("upload_result");

		// 업로드된 파일이 저장될 폴더 경로
		String savePath = "c:/upload";

		File dir = new File(savePath);
		if (dir.exists() == false) {
			// 만약 폴더가 없으면 만들라는 문장
			dir.mkdir();
		}

		// 때에 따라서는 사용자가 업로드한 원래 파일이름과
		// 서버에 저장되는 파일 이름이 달라질 수 있음.
		String savedName = savePath + "/" + book.getMyFile().getOriginalFilename() + new Random().nextInt(1000000);
		File savedFile = new File(savedName);

		try {
			// 클라이언트의 파일을 좀전에 만든 빈 파일에
			// 옮겨담기!
			book.getMyFile().transferTo(savedFile);

			mv.addObject("originalName", book.getMyFile().getOriginalFilename());
			mv.addObject("savedPath", savedName);
			mv.addObject("title", book.getTitle());
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response) {
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"Koalalala.jpg\"");

		try {
			// 다운로드 해줄 파일 읽어들이는 Stream
			FileInputStream is = new FileInputStream("c:/upload/Koala.jpg226439");
			// 읽어들인 파일을 보낼 response의 Stream
			ServletOutputStream os = response.getOutputStream();

			byte[] buf = new byte[1024];
			int size = 0;

			while ((size = is.read(buf)) != 0) {
				os.write(buf, 0, size);
			}

			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/uploadFormMovie.do")
	public String uploadFormMovie() {
		return "upload_form_movie";
	}

	@RequestMapping(value = "/uploadMovie.do", method = RequestMethod.POST)
	public ModelAndView uploadMovie(Movie movie) {
		ModelAndView mv = new ModelAndView("upload_movie_result");

		String savePath = "c:/upload_movie";

		File dir = new File(savePath);
		if (dir.exists() == false) {
			dir.mkdir();
		}
		// 파일 여러개를 저장하는 반복문
		for (MultipartFile f : movie.getMyFile()) {
			String savedName = savePath + "/" + f.getOriginalFilename() + new Random().nextInt(1000000);
			File savedFile = new File(savedName);

			try {
				f.transferTo(savedFile);

				System.out.println("원래이름:" + f.getOriginalFilename());
				System.out.println("저장된이름:" + savedName);
				System.out.println("---------------");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		mv.addObject("uploadedFileNames", movie.getMyFile());
		return mv;
	}
///////////////////////////////////////////////////////
	// 업로드된 파일이 현재 프로젝트 내부 폴더에 저장되게
	// 하고싶으면 파일 저장경로를 아래와 같이 하면 됨.
//	public ModelAndView uploadMovie
//			(HttpServletRequest request, Movie movie) {
//		String savePath = 
//		request.getServletContext().getRealPath("img");
//	}
}



