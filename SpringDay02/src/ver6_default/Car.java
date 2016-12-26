package ver6_default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sonata")
public class Car {
	// Component가 없을 때
//	@Autowired(required=false)
	private Tire tire;
	
	public Car(){}
	
//	@Autowired 생성자에는 잘 안검
	public Car(Tire tire){
		this.tire = tire;
	}
	
	// 2개 이상일 경우에는 @Qualifier를 추가 Qualifier에 추가되는 것으로 실행
	@Autowired
	@Qualifier("koreaTire")
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo(){
		System.out.println("현재 장착 타이어:"+tire.getModel());
	}
}
