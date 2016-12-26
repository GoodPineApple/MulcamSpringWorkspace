package ver6_default;

import org.springframework.stereotype.Component;

@Component
public class KoreaTire implements Tire{
	@Override
	public String getModel() {
		return "±¹»ê";
	}	
}
