package ver7;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Girl implements Person {
	@Override
	public void makeFood() throws Exception {
		/////////////////////////////////////////////
		// �ٽɰ��ɻ���
		System.out.println("���� �����.");
		if (new Random().nextBoolean()) {
			throw new Exception("���Ⱑ ����!!");
		}
		//////////////////////////////////////////////
	}
}