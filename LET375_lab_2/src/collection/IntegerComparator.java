package collection;
import java.util.*;

public class IntegerComparator implements Comparator<Collection<Integer>> {
    @Override    
	public int compare( Collection<Integer> c1, Collection<Integer> c2 ) {
    		Integer a = Collections.max(c1) < Collections.min(c2) ? 1 : -1;
    		return a; 
        }
}

