package ver2_2;

public class Driver {
	public static void main(String[] args) {
		Car mycar = new Car();
		Tire t = new KoreaTire();
		
		mycar.setTire(t); // Á¶¸³

		mycar.printCarInfo();
	}
}
