package com.pineapple.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Member;
import com.pineapple.service.MemberService;
import com.pineapple.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	public void setService(MemberService service){
		this.service = service;
	}
	///////////////////////////////////////////////////////////
	
	@RequestMapping("/")
	public String index(){
    	return "index";
    }
	
	@RequestMapping("/login.do")
	public ModelAndView login(HttpSession session, String id, String password){
    	boolean loginResult = service.loginCheck(id, password);
    	session.setAttribute("id", id);
    	return new ModelAndView("index", "result", loginResult);
    }
	
	@RequestMapping("/joinForm.do")
	public String joinForm(){
		return "join_form";
	}
	
	@RequestMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(String id){
		boolean result = service.idCheck(id);
		return result+"";
	}
	
	@RequestMapping("/join.do")
	public String join(String id, String password, String email, String phone){
		MemberVO member = new MemberVO(id, password, email, phone);
		boolean result = service.join(member);
		if(result){
			return "join_success";
		}else{
			return "join_fail";
		}
	}
	
	
}
