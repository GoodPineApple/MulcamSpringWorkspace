package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repository.FileDao;

@Controller
public class FileController {
	
	@Autowired
	private FileDao dao;
	public void setDao(FileDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("/fileList.do")
	public ModelAndView fileList(){
		ModelAndView mv = new ModelAndView("file_list");
		mv.addObject("fileList", dao.selectAll());
		return mv;
	}
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView uploadFile(){
		
	}
	
}
