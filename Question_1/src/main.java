import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Long> numbers=new ArrayList<Long>();
		numbers.add((long) 100000);
		numbers.add((long) 200000);
		numbers.add((long) 300000);
		numbers.add((long) 400000);
		numbers.add((long) 500000);
		List<String> strings=new ArrayList<String>();
		strings.add("String 1");
		strings.add("String 2");
		strings.add("String 3");
		strings.add("String 3");
		strings.add("String 4");
		strings.add("String 5");
		strings.add("String 3");
		Date date = new Date();
				
		//Change date
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, 10);
		date = c.getTime();
		
		MyClass object = new MyClass(date, "Test Name", numbers, strings);
		System.out.println(object.toString());
		System.out.println(object.isHistoric());
		
		// Change Lists Numbers and Strings
		numbers.add((long)600000);
		numbers.add((long)700000);
		numbers.add((long)800000);
		
		strings.add("String 6");
		strings.add("String 7");
		strings.add("String 8");

		System.out.println(object.toString());
		
		object.removeString("String 3");
		System.out.println(object.toString());
	}


}
