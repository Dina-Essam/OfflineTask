import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashmap {

	// this list is shared
	static Map<String, List<Integer>> data = new HashMap<String, List<Integer>>();

	// this method is used from different places and threads
	public synchronized void SetValue(String key, Integer i) {
		List<Integer> value = data.get(key);
		if(value == null){
			value = new ArrayList<Integer>();
			data.put(key, value );
		}
		value .add(i);
	}
	
}
