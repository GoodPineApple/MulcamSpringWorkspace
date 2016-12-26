package ver7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(void makeFood())")
	public void my_point(){}
	
	@Around("my_point()")
	public void my_around(ProceedingJoinPoint target){
		// before
		System.out.println("�谡 ������."); 
		try {
			/////////////////////////////////////////////
			// �ٽɰ��ɻ��� �޼ҵ� �������.
			target.proceed(); 
			/////////////////////////////////////////////
			// after returning
			System.out.println("������ �Դ´�.");
		} catch (Throwable e) {
			// after throwing
			System.out.println(e.getMessage());
			System.out.println("����!!!!!!");
		} finally{
			// after
			System.out.println("�������� �Ѵ�.");
		}
	}
}
