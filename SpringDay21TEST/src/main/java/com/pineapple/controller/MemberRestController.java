package com.pineapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pineapple.service.MemberService;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberService service;
	
	////////////////////////////////////////////////////
	
}
