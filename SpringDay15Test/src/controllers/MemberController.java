package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="login_form.do")
	public String loginForm(){
		return "login_form";
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public ModelAndView login(HttpSession session,
			@RequestParam(value="id")String id,
			@RequestParam(value="password")String password){
		ModelAndView mv = new ModelAndView();
		System.out.println("test" + id + ", " + password);
		if(service.login(id,password)){
			session.setAttribute("loginId", id);
			mv.setViewName("login_sucess");
		} else {
			mv.setViewName("login_fail");
		}
		return mv;
	}
}
