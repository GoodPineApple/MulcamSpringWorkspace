package ver2;

import java.util.Random;


public class Girl implements Person{
	@Override
	public void makeFood() throws Exception{
		
		///////////////////////////////////////////////////////////
		// �ٽ� ���ɻ���
		System.out.println("�ø��� �����.");
		if(new Random().nextBoolean()){
			throw new Exception("�ҳ���!!");
		}
		///////////////////////////////////////////////////////////		
	}
}