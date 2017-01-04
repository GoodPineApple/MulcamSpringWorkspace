package com.pineapple.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pineapple.repository.ArticleMapper;
import com.pineapple.repository.MemberMapper;
import com.pineapple.vo.ArticleVO;
import com.pineapple.vo.MemberVO;
	 
@RestController
public class TestController {
	
//	@Autowired
////	private MemberMapper mapper;
//	private ArticleMapper amapper;
//	
//    @RequestMapping("/")
//    public String test(){
//        return "Hello World member and article";
//    }
//    
////    @RequestMapping("/member")
////    public MemberVO memberTest(){
////    	MemberVO member = mapper.memberSelect(3);
////        return member;
////    }
//    
//    @RequestMapping("/article")
//    public List<ArticleVO> articleTest(){
////    	ArticleVO result = amapper.articleSelect(4);
//    	
//    	List<ArticleVO> articles = amapper.articleSelectList(); 
//    	
//		return articles;    	
//    }
//    
//    @RequestMapping("/board")
//    public ModelAndView board(){
//    	List<ArticleVO> board = amapper.articleSelectList();
//    	return new ModelAndView("boardList", "list", board);
//    }
    
}


