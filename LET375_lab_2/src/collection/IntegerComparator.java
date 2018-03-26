package collection;
import java.util.*;

public class IntegerComparator implements Comparator<Integer> {
	public int compare( Integer i1, Integer i2 ) {
    		return Integer.compare(i1, i2); 
        }
}