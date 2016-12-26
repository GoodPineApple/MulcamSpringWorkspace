package ver2;

public class MyAspect {
	// 핵심관심사항 수행전 작업
	public void my_before(){
		System.out.println("배가 고프다.");
	}
	
	// 핵심관심사항 정상 종료후 작업
	public void my_after_returning(){
		System.out.println("음식을 먹는다.");
	}
	
	// 핵심관심사항 오류 발생시 작업
	public void my_after_throwing(){
		System.out.println();
		System.out.println("엄마를 부른다.");
	}
	
	public void my_after(){
		System.out.println("설거지를 한다.");
	}
}
