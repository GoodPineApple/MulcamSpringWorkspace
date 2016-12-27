package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.Article;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping(value="write_form.do")
	public String writeForm(){
		return "write_Form";
	}
	
	@RequestMapping(value="write.do",method=RequestMethod.POST)
	public ModelAndView write(Article article){
		ModelAndView mv = new ModelAndView();
		int result = service.insertArticle(article);
		mv.setViewName("write_sucess");
		return mv;
	}
	@RequestMapping(value="boardList.do")
	public ModelAndView boardList(
			@RequestParam(value="page",defaultValue="1")int page){
		ModelAndView mv = new ModelAndView("board_list");
		mv.addObject("articlePage",service.makePage(page));
		return mv;
	}
	@RequestMapping("/read.do")
    public ModelAndView read
                (HttpSession session,int articleNum)
    {
        String loginId = 
                (String)session.getAttribute("loginId");
        Article article = 
                service.read(articleNum, loginId);
         
        ModelAndView mv = new ModelAndView("read");
        mv.addObject("article", article);
        return mv;
    }
	@RequestMapping("/deleteForm.do")
	public String delete(HttpSession session,int articleNum){
		String loginId = (String)session.getAttribute("loginId");
		if(service.delete(loginId,articleNum)){
			return "delete_sucess";
		} else {
			return "delete_fail";
		}
	}
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(HttpSession session,int articleNum){
		String loginId = (String)session.getAttribute("loginId");
		Article article = service.read(articleNum, loginId);
		return new ModelAndView("update_form","article" , article);
	}
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	public ModelAndView update(Article article){
		ModelAndView mv = new ModelAndView();
		service.updateArticle(article);
		System.out.println(article.getArticleNum());
		return new ModelAndView("update_success", "articleNum", article.getArticleNum());
	}
	@RequestMapping("/writeReplyForm.do")
	public ModelAndView replyForm(int articleNum){
		return new ModelAndView("reply_form","articleNum" , articleNum);
	}
	@RequestMapping(value="reply.do",method=RequestMethod.POST)
	public ModelAndView reply(Article article,int articleNum){
		ModelAndView mv = new ModelAndView();
		Article savedArticle = service.select(articleNum);
		article.setFamily(savedArticle.getFamily());
		article.setDepth(savedArticle.getDepth()+1);
		article.setParent(articleNum);
		service.insertReply(article);
		mv.setViewName("reply_sucess");
		return mv;
	}
	
}
