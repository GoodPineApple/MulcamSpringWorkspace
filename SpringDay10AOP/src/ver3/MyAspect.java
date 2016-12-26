package ver3;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void my_around(ProceedingJoinPoint target){
		// before
		System.out.println("배가 고프다."); 
		try {
			/////////////////////////////////////////////
			// 핵심관심사항 메소드 실행시점.
			target.proceed(); 
			/////////////////////////////////////////////
			// after returning
			System.out.println("음식을 먹는다.");
		} catch (Throwable e) {
			// after throwing
			System.out.println(e.getMessage());
			System.out.println("엄마!!!!!!");
		} finally{
			// after
			System.out.println("설거지를 한다.");
		}
	}
}
