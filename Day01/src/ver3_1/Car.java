package ver3_1;

public class Car {
	private Tire tire;
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo(){
		System.out.println
			("현재 차량 장착 타이어 : "+ tire.getModel());
	}
}
