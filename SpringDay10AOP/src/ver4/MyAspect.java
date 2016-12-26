package ver4;

import org.aspectj.lang.JoinPoint;






// 공통 관심사항 구현 클래스
public class MyAspect {
	// 핵심관심사항에 전달되는 인자값을 before에서 먼저받음.
	// args 배열의 크기는 핵심관심사항에 들어가는 인자의 갯수임
	public void my_before(JoinPoint joinpoint) {
		System.out.println("배가 고프다.");
		Object[] args = joinpoint.getArgs(); // 핵심관심사항에 들어가는 데이터
		System.out.println("before 준비물 : " + args[0]);
	}

	// 핵심관심사항의 반환값은 자료형은 알 수 없지만 갯수는 항상 1개이므로
	// Object 변수 하나로 받아오면 됨.
	public void my_after_returning(Object result) {
		System.out.println(result + " 음식을 먹는다.");
	}

	// 핵심관심사항 수행도중 예외발생으로 중단됬을 때 예외객체 핸들링을 원한다면
	// 아래와 같이 예외객체를 받아볼 수 있음.
	public void my_after_throwing(Exception ex) {
		System.out.println(ex.getMessage() + "..엄마!!!!!");
	}

	public void my_after() {
		System.out.println("설거지를 한다.");
	}

}
