package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("loginForm.do")
	public String loginForm(){
		// ��Ʈ�ѷ� �޼ҵ��� ��ȯ���� String�� ��쿡�� ��ȯ���� view�� �̸��̵�
		// ������ login_form.jsp ������ ���õ� ����
		return "login_form";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(String userId, String userPw){
		ModelAndView mv = new ModelAndView();
		
		if(userId.equals(userPw)){
			mv.setViewName("login_success");
			mv.addObject("msg","�α��� �����Դϴ�!!");
			mv.addObject("loginId",userId);
		} else{
			mv.setViewName("login_error");
		}
		return mv;
	}
}
