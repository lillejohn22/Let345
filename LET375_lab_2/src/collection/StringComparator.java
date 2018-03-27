package collection;
import java.util.Comparator;

/* If length of s1 < length of s2, return -1
 * If length of s1 == length of s2, return 0
 * If length of s1 > length of s2, return 1
 */
public class StringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return Integer.compare(s1.length(), s2.length()); 
	}
}
