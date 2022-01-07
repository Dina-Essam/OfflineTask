import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedMap {
	
	// this list is shared
	static Map<String, List<Integer>> data = Collections.synchronizedMap(new HashMap<String, List<Integer>>());

	// this method is used from different places and threads
	public void SetValue(String key, Integer i) {
		synchronized (data) {
			List<Integer> value = data.get(key);
			if(value == null){
				value = new ArrayList<Integer>();
				data.put(key, value );
			}
			value .add(i);
		}
	}

}
