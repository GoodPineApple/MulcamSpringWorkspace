package controller;

import org.apache.catalina.tribes.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repository.BookDao;
import service.BookService;
import vo.Book;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	public void setMemberService(BookService service){
		this.service = service;
	}
	
	@RequestMapping("/main.do")
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("bookList", service.selectBookList());
		return mv;
	}
	
	@RequestMapping("/addBook.do")
	public String addBook(){
		return "add_book";
	}
	
	@RequestMapping(value="/addBookResult.do", method=RequestMethod.POST)
	public ModelAndView addBookResult(Book book){
//		System.out.println(book);
		ModelAndView mv = new ModelAndView();
		boolean result = service.insertBook(book);
		mv.setViewName("add_book_result");
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/readBook.do")
	public ModelAndView readBook(int bookNum){
		ModelAndView mv = new ModelAndView();
		Book book = service.selectBook(bookNum);
		mv.setViewName("read");
		mv.addObject("book", book);
		return mv;
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(int bookNum){
		ModelAndView mv = new ModelAndView();
		Book book = service.selectBook(bookNum);
		mv.setViewName("update_form");
		mv.addObject("book", book);
		return mv;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(int bookNum){
		ModelAndView mv = new ModelAndView();
		boolean result = service.deleteBook(bookNum);
		mv.setViewName("delete_result");
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(Book book){
		System.out.println(book);
		ModelAndView mv = new ModelAndView();
		boolean result = service.updateBook(book);
		mv.setViewName("update_result");
		mv.addObject("result", result);
		return mv;
	}
}
