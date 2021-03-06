package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	public MemberController(MemberService service){
		this.service = service;
	}
	
	public MemberController(){}
	
	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "login_form";
	}
	
	@RequestMapping("/joinForm.do")
	public String joinForm(){
		return "join_form";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpSession session, String id, String pw){
		if(service.loginCheck(id, pw)){
			session.setAttribute("loginId", id);
			return "login_success";
		} else{
			return "login_error";
		}
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(String id, String pw, String email, String phone){
		Member member = new Member(id, pw, email, phone);
		if(service.join(member)){
			return "join_success";
		} else{
			return "join_error";
		}
	}
	
	@RequestMapping("/loginStatus.do")
	public String loginStatus(){
		return "login_status";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "logout";
	}
}
