// Author(s):
// Version: 
// Date:	
import java.io.*;
import java.util.*;

public class WordLists {
	private Reader in = null;
	HashMap<String, Integer> unsortedDict = new HashMap<String, Integer>();
	TreeMap<String, Integer> alfaSortedDict = new TreeMap<String, Integer>();
	List<String> backwardsSortedDict = new LinkedList<String>(); // Backwards dictionary do not need to be a Map
	TreeMap<String, Integer> freqSortedDict = new TreeMap<String, Integer>();
	
	// Constructor
	public WordLists(String inputFileName) throws IOException{
	    File textFile = new File("provtext.txt");
	    in = new BufferedReader(new FileReader(textFile));
	}

	// Prints out dictionaries
	private void dictToTextFile( Map<String,Integer> argMap ) {
		// implement
	}
	
	private boolean isPunctuationChar(char c) {
	    final String punctChars = ",.:;?!";
	    return punctChars.indexOf(c) != -1;
	}
	
	private String getWord() throws IOException {
		int state = 0;
		int i;
		String word = "";
		while ( true ) {
			i = in.read();
			char c = (char)i;
			switch ( state ) {
			case 0:
				if ( i == -1 )
					return null;
				if ( Character.isLetter( c ) ) {
					word += Character.toLowerCase( c );
					state = 1;
				}
				break;
			case 1:
				if ( i == -1 || isPunctuationChar( c ) || Character.isWhitespace( c ) )
					return word;
				else if ( Character.isLetter( c ) ) 
					word += Character.toLowerCase( c );
				else {
					word = "";
					state = 0;
				}
			}
		}
	}
	
	// Returns a Set with every word in reverse
	// Arguments can be e.g. List or Set (due to argument Collection)
	private List<String> reverseAllWords( Collection<String> argSet) {
		List<String> tempList = new LinkedList<String>();
		for (String word : argSet) {
    			word = new StringBuilder(word).reverse().toString(); // Reverse word
    			tempList.add(word); 
		}
    			return tempList;
	}

	// May we skip it?
	private String reverse(String s) {
		// define!
		return "";
	}

	private void computeWordFrequencies() throws IOException {
	    String word;
	    while ( (word = getWord()) != null ) {
	    		if ( unsortedDict.containsKey(word)) {
	    			unsortedDict.put(word, unsortedDict.get(word) + 1); // Overwrites with new value
	    		}
	    		else
	    			unsortedDict.put(word, 1);
	    }
	}

	private void computeFrequencyMap() {
          // define!
	}



	private void computeBackwardsOrder() {
		TreeSet<String> workSet = new TreeSet<String>();
		TreeMap<String, Integer> workMap = new TreeMap<String, Integer>();
		workMap.putAll(unsortedDict); // Just like alfaSortedDict. Needed to be able
		// to compute backwardsDict without having to know alfaSortedDict. Words are sorted.
		
		 // A SET of sorted (by last character) words (that are reversed):
		workSet.addAll(reverseAllWords(workMap.keySet()));
		// A LIST of sorted (by last character) words (that are not reversed):
		backwardsSortedDict.addAll(reverseAllWords(workSet)); 
	}

	
	public static void main(String[] args) throws IOException { // Main throws Exception, no good?
		WordLists wl = new WordLists("provtext.txt");  // arg[0] contains the input file name

		// Needed to compute each dictionary type. Instantiates a Set called unsortedDict.
		wl.computeWordFrequencies();
		
		// Convert from HashMap (unsortedDict) to TreeMap (alfaSortedDict) to get alphabetical sorting.
	    wl.alfaSortedDict.putAll(wl.unsortedDict);
	    
	    // Determine backwards dictionary
	    wl.computeBackwardsOrder();

	    
		//wl.computeFrequencyMap();
		
	
		System.out.println("Finished!");
	}
}



















