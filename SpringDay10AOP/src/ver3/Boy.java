package ver3;

import java.util.Random;

public class Boy implements Person {
	@Override
	public void makeFood() throws Exception {
		/////////////////////////////////////////////
		// �ٽɰ��ɻ���
		System.out.println("�ø��� �����.");
		if (new Random().nextBoolean()) {
			throw new Exception("�ҳ���!!!");
		}
		//////////////////////////////////////////////
	}
}
