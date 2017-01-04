package com.pineapple.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pineapple.service.ArticleService;
import com.pineapple.vo.ArticleVO;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	public void setService(ArticleService service){
		this.service = service;
	}
	//////////////////////////////////////////////////
	
	@RequestMapping("/boardList.do")
	public ModelAndView login(){
		List<ArticleVO> board = service.selectArticleList();
   		return new ModelAndView("board_list", "list", board);
    }
	
	@RequestMapping("writeForm.do")
	public String writeForm(){
		return "write_form";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public ModelAndView write(HttpSession session,ArticleVO article){
		String writer = (String)session.getAttribute("id");
		article.setWriter(writer);

		ModelAndView mv = new ModelAndView("write_result","result", service.insertArticle(article));
		return mv;
	}
	
	@RequestMapping(value="/{articleNum}",method=RequestMethod.GET)
	public ModelAndView view(@PathVariable("articleNum") int articleNum) throws Exception{
	    
	    ArticleVO article = service.selectArticle(articleNum);
	    service.hitPlus(articleNum);
	    
	    return new ModelAndView("board_view","article",article);
	}


	
}
