package ver6;

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
	
	@Pointcut("execution(void makeFood())")
	public void my_point(){}
	
	@Before("my_point()")
	public void my_before() {
		System.out.println("배가 고프다.");
	}

	@AfterReturning("my_point()")
	public void my_after_returning() {
		System.out.println("음식을 먹는다.");
	}

	@AfterThrowing("my_point()")
	public void my_after_throwing() {
		System.out.println("엄마를 부른다.");
	}

	@After("my_point()")
	public void my_after() {
		System.out.println("설거지를 한다.");
	}
}
