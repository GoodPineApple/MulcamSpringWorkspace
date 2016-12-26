package test02_interface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Sample implements InitializingBean, DisposableBean{
	public Sample() {
		System.out.println("Sample 생성자");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println
			("Sample의 인터페이스 메소드 : afterPropertiesSet()");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println
			("Sample의 인터페이스 메소드 : destroy()");
	}
}
