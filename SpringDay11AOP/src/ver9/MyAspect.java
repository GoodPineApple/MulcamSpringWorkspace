package ver9;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 공통관심사항 구현 클래스
@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* makeFood(..))")
	public void my_point(){}
	
	@Around("my_point()")
	public void my_around(ProceedingJoinPoint joinPoint){
		System.out.println("배가 고프다"); // before
		Object[] args = joinPoint.getArgs();
		System.out.println("before 준비물:"+args[0]);
		try {
			Object result = joinPoint.proceed(); // 핵심관심사항 실행
			
			System.out.println(result+"음식을 먹는다."); // after_returning
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"엄마를 부른다."); // after_throwing
		} finally{
			System.out.println("설거지를 한다."); // after
		}
	}
}
