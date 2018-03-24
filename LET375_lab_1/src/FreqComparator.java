/* Function object for lab 1 in course LET375.
 * Used in WordLists.java
 */

import java.util.Comparator;
import java.util.Map;

	public class FreqComparator implements Comparator<Map<String, Integer>> {
		
		/* @param Map objects map1 and map2   
		 *  @return	1 if the occurrence of keyword key1 in map1 is greater than keyword key2 in map2.
		 *  			0 if the keywords key1 and key2 occurring an equal number of times
		 *  			-1 if the occurrence of keyword key1 in map1 is less than keyword key2 in map2.
		 * 
		 */
		@Override
		public int compare(Map<String, Integer> map1, Map<String, Integer> map2) {
			for (String key1 : map1.keySet()) {
				for (String key2 : map2.keySet())
					if ( map1.get(key1) > map2.get(key2))
						return 1;
					else if ( map1.get(key1) == map2.get(key2) ) // If equally frequent, sort alphabetically
						return key1.compareTo(key2);
				}
					return -1;
		}
}