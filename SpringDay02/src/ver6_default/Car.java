package ver6_default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sonata")
public class Car {
	// Component�� ���� ��
//	@Autowired(required=false)
	private Tire tire;
	
	public Car(){}
	
//	@Autowired �����ڿ��� �� �Ȱ�
	public Car(Tire tire){
		this.tire = tire;
	}
	
	// 2�� �̻��� ��쿡�� @Qualifier�� �߰� Qualifier�� �߰��Ǵ� ������ ����
	@Autowired
	@Qualifier("koreaTire")
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo(){
		System.out.println("���� ���� Ÿ�̾�:"+tire.getModel());
	}
}
