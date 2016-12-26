package ver5;

import org.springframework.stereotype.Component;
//이름 안붙이면 클래스이름의 첫글자 소문자로 바꾼 이름 자동
@Component 
public class KoreaTire implements Tire{
	@Override
	public String getModel() {
		return "국산";
	}
	
}
