package ver1;

import java.util.Random;

import ver2.Person;

public class Girl implements Person{

	@Override
	public void makeFood() {
		System.out.println("배가 고프다.");
		try{
			///////////////////////////////////////////////////////////
			// 핵심 관심사항
			System.out.println("갈비를 만든다.");
			if(new Random().nextBoolean()){
				throw new Exception("고기가 없다!!");
			}
			///////////////////////////////////////////////////////////
			System.out.println("음식을 먹는다.");
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("엄마를 부른다.");
		} finally{
			System.out.println("설거지를 한다.");
		}
	}
}
