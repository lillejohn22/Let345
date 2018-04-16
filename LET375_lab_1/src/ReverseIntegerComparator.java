import java.util.Comparator;

public class ReverseIntegerComparator implements Comparator<Integer> {
	public int compare(Integer i1, Integer i2) {
		return Integer.compare(i2, i1); // NOTE: "reversed order" of arguments
	}
}
