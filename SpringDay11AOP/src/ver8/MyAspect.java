package ver8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;





@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* makeFood(*))")
	public void my_point(){}
	
	@Before("my_point()")
	public void my_before(JoinPoint joinpoint) {
		System.out.println("배가 고프다.");
		Object[] args = joinpoint.getArgs(); // 핵심관심사항에 들어가는 데이터
		System.out.println("before 준비물 : " + args[0]);
	}

	@AfterReturning(pointcut="my_point()", returning="result")
	public void my_after_returning(Object result) {
		System.out.println(result + " 음식을 먹는다.");
	}

	@AfterThrowing(pointcut="my_point()", throwing="ex")
	public void my_after_throwing(Exception ex) {
		System.out.println(ex.getMessage() + "..엄마!!!!!");
	}

	@After("my_point()")
	public void my_after() {
		System.out.println("설거지를 한다.");
	}

}
