package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	public void setService(MemberService service) {
		this.service = service;
	}
///////////////////////////////////////////////////////
	@RequestMapping("/joinForm.do")
	public String joinForm(){
		return "join_form";
	}
}









