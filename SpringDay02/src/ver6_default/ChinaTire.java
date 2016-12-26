package ver6_default;

import org.springframework.stereotype.Component;

@Component
public class ChinaTire implements Tire {
	@Override
	public String getModel() {
		return "´ë·ú";
	}
}
