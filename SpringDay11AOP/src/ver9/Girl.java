package ver9;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Girl implements Person {
	@Override
	public String makeFood(int arg) throws Exception {
		/////////////////////////////////////////////
		// �ٽɰ��ɻ���
		System.out.println("���� �����."+arg);
		if (new Random().nextBoolean()) {
			throw new Exception("��Ⱑ ����!!");
		}
		//////////////////////////////////////////////
		return "���� ������ ��������.";
	}

}
