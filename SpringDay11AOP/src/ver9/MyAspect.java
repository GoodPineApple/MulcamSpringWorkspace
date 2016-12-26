package ver9;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// ������ɻ��� ���� Ŭ����
@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* makeFood(..))")
	public void my_point(){}
	
	@Around("my_point()")
	public void my_around(ProceedingJoinPoint joinPoint){
		System.out.println("�谡 ������"); // before
		Object[] args = joinPoint.getArgs();
		System.out.println("before �غ�:"+args[0]);
		try {
			Object result = joinPoint.proceed(); // �ٽɰ��ɻ��� ����
			
			System.out.println(result+"������ �Դ´�."); // after_returning
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"������ �θ���."); // after_throwing
		} finally{
			System.out.println("�������� �Ѵ�."); // after
		}
	}
}
