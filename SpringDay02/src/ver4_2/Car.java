package ver4_2;

public class Car {
	private Tire tire;
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printCarInfo(){
		System.out.println("현재 장착 타이어:"+tire.getModel());
	}
}
