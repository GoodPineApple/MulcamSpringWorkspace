package ver2;

public class MyAspect {
	// �ٽɰ��ɻ��� ������ �۾�
	public void my_before(){
		System.out.println("�谡 ������.");
	}
	
	// �ٽɰ��ɻ��� ���� ������ �۾�
	public void my_after_returning(){
		System.out.println("������ �Դ´�.");
	}
	
	// �ٽɰ��ɻ��� ���� �߻��� �۾�
	public void my_after_throwing(){
		System.out.println();
		System.out.println("������ �θ���.");
	}
	
	public void my_after(){
		System.out.println("�������� �Ѵ�.");
	}
}