package ver1;

import java.util.Random;

import ver2.Person;

public class Boy implements Person {

	@Override
	public void makeFood() {
		System.out.println("�谡 ������.");
		try{
			///////////////////////////////////////////////////////////
			// �ٽ� ���ɻ���
			System.out.println("�ø��� �����.");
			if(new Random().nextBoolean()){
				throw new Exception("�ҳ���!!");
			}
			///////////////////////////////////////////////////////////
			System.out.println("������ �Դ´�.");
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("������ �θ���.");
		} finally{
			System.out.println("�������� �Ѵ�.");
		}
		
	}

}