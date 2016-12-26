package ver5;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void my_around(ProceedingJoinPoint target){
		//before
		System.out.println("배가 고프다.");
		// 핵심 관심사항 수행 전에 입력 데이터 받아보기
		Object[] args = target.getArgs();
		System.out.println(args[0]+"인분 음식을 만들겠다.");
		try {
			// 핵심 관심사항 실행시키기
			Object result = target.proceed();
			
			// after returning : 정상종료 후
			// 핵심관심사항 수행 결과 데이터 받아보기
			System.out.println(result+"음식을 먹는다~");
		} catch (Throwable e) {
			// after throwing : 핵심관심사항 수행중 에러남
			System.out.println(e.getMessage()+"엄마!!!!");
		} finally{
			// after : 어찌되었건 종료할 때 무조건 실행
			System.out.println("설거지를 한다..");
		}
	}
}
