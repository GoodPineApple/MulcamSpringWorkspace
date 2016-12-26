package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("loginForm.do")
	public String loginForm(){
		// 컨트롤러 메소드의 반환형이 String인 경우에는 변환값이 view의 이름이됨
		// 지금은 login_form.jsp 파일이 선택될 것임
		return "login_form";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(String userId, String userPw){
		ModelAndView mv = new ModelAndView();
		
		if(userId.equals(userPw)){
			mv.setViewName("login_success");
			mv.addObject("msg","로그인 성공입니다!!");
			mv.addObject("loginId",userId);
		} else{
			mv.setViewName("login_error");
		}
		return mv;
	}
}
