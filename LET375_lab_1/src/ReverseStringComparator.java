import java.util.Comparator;
import java.lang.StringBuilder;

public class ReverseStringComparator implements Comparator<String>{
	
	
	public int compare(String s1, String s2) {
		s1 = new StringBuilder(s1).reverse().toString();
		s2 = new StringBuilder(s2).reverse().toString();
		
		return s1.compareTo(s2);
	}
}
