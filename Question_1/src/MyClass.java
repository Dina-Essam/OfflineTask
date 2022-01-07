import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MyClass {
	
	private Date m_time;
	private String m_name;
	private List<Long> m_numbers;
	private List<String> m_strings;
	
	public MyClass(Date time, String name, List<Long> numbers, List<String> strings) {
		m_time = time;
		m_name = name;
		
		// We assign here a reference to a List, if the list is modified outside this class, it will affect this MyClass
		//m_numbers = numbers;
		//m_strings = strings;
		
		m_numbers = new ArrayList<Long>(numbers);
		m_strings = new ArrayList<String>(strings);
	}
	
	
	/*
	 * Bug here
	 * we not compare all object members
	 * 
	 */
	public boolean equals2(Object obj) {
		
		//if (obj instanceof MyClass) {
		//	return m_name.equals(((MyClass) obj).m_name);
		//}
		//return false;
		return obj instanceof MyClass && m_name.equals(((MyClass) obj).m_name);
		
	}
	
	/*
	 * Here we check all member of the object
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
	        return true;
		if (!(obj instanceof MyClass))
			return false;
		final MyClass other = (MyClass) obj;
		if (!m_time.equals(other.m_time))
			return false;
        if (!m_name.equals(other.m_name))
        	return false;
        if (!m_numbers.equals(other.m_numbers))
        	return false;
        return m_strings.equals(other.m_strings);
	}
	
	
	
	/*
	 * Must override hashcode bec we override equals 
	 * so when use maps will not create bugs with equal objects
	 */
	@Override
    public int hashCode() {
		int hashCode = 1;
		hashCode = 31 * hashCode + m_name.hashCode()
		        + m_numbers.hashCode()
		        + m_strings.hashCode()+ m_time.hashCode();
        return hashCode;
    }
	
	
	/*
	 * Use StringBuilder or StringBuffer instead of String
	 * StringBuilder is nonSynchronized 
	 * StringBuffer is synchronized 
	 * 
	 * String is immutable
	 * We can also toString all class member
	 */
	@Override
	public String toString() {
		//String out = m_name;
		StringBuilder out = new StringBuilder();
		out.append(m_name);
		out.append(m_time);
		
		for (long item: m_numbers) 
			//out += " " + item;
			out.append(" "+Long.toString(item));
		
		for (String item: m_strings) 
			out.append(" "+item);
		
		return out.toString();
	}
	
	
	/*
	 * after remove element in List 
	 * it will shift by one so we will skip the next element
	 * 
	 */
	public void removeString(String str) {

//				for (int i = 0; i < m_strings.size(); i++) {
//					if (m_strings.get(i).equals(str)) {
//						m_strings.remove(i);
//					}
//				}
		
		//This will remove the first element equals to the str
		 m_strings.remove(str);
		//This will remove all elements equal to the str
		 m_strings.removeAll(Collections.singleton(str));
	}
	
	
	
	public boolean containsNumber(long number) {
		//for (long num: m_numbers) {
		//	if (num == number) {
		//		return true;
		//	}
		//}
		//return false;
		return m_numbers.contains(number);
	}
	
	
	public boolean isHistoric() {
		return m_time.before(new Date());
	}

	
}
