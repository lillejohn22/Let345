package collection;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return Integer.compare(s1.length(), s2.length()); // if s1 longer than s2 return -1 
	}
}
