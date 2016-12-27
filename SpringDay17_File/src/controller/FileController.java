package controller;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import vo.Book;

@Controller
public class FileController {
	
	@RequestMapping("uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public void upload(Book book){
		
	}
}
