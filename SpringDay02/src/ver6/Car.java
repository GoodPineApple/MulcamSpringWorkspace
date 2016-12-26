package ver6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sonata")
public class Car {
	private Tire tire;
	
	public Car(){}
	
	public Car(Tire tire){
		this.tire = tire;
	}
	
	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo(){
		System.out.println("���� ���� Ÿ�̾�:"+tire.getModel());
	}
}
