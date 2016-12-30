package com.sds.test20;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "login_form";
	}
	
	@RequestMapping(value="/login.do",
							method=RequestMethod.POST)
	public String login(HttpSession session,
							String id, String pw){
		if(id.equals(pw)){
			session.setAttribute("loginId", id);
			return "login_success";
		}else{
			session.invalidate();
			return "login_fail";
		}
	}
	
	@RequestMapping("/boardList.do")
	public String boardList(){
		return "board_list";
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm(){
		return "write_form";
	}
	
//	@RequestMapping("/boardList.do")
//	public String boardList
//		(HttpSession session, HttpServletResponse response){
//		if(session.getAttribute("loginId")!=null)
//			return "board_list";
//		else
//			return "login_form";
//	}
//	
//	@RequestMapping("/writeForm.do")
//	public String writeForm
//		(HttpSession session, HttpServletResponse response) 
//		throws IOException{
//		
//		if(session.getAttribute("loginId")!=null)
//			return "write_form";
//		else{
//			response.sendRedirect("loginForm.do");
//			return null;
//		}
//	}
	@RequestMapping("/hello.do")
	public String hello(){
		return "hi";
	}
}




