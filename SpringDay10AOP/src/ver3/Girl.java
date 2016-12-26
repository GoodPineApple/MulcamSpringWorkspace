package ver3;

import java.util.Random;

public class Girl implements Person {
	@Override
	public void makeFood() throws Exception {
		/////////////////////////////////////////////
		// 핵심관심사항
		System.out.println("갈비를 만든다.");
		if (new Random().nextBoolean()) {
			throw new Exception("고기가 없다!!");
		}
		//////////////////////////////////////////////
	}
}
