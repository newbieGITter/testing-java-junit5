package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

	Map<String, Object> hashMap = new HashMap<>();
	
	@Override
	public void addAttribute(String key, Object o) {
		hashMap.put(key, o);
	}

	@Override
	public void addAttribute(Object o) {
		// do nothing ... 
	}

	

}
