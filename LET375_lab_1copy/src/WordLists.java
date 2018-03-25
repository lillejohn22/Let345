// Author(s): Anton Frigård, Johan Nilssom
// Version: 1
// Date:	 2018-03-25
import java.io.*;
import java.util.*;

public class WordLists {
	
	// Instance variables
	private HashMap<String, Integer> unsortedDict = new HashMap<String, Integer>(); // every dict is based on this
	private TreeMap<String, Integer> alfaSortedDict = new TreeMap<String, Integer>();
	private List<String> backwardsSortedDict = new LinkedList<String>();
	private Set<Map<String, Integer>> freqSortedDict;
	
	private Reader in = null;
	Map<String, Integer> workMap = new HashMap<String, Integer>(); // used for computing
	
	// Constructor
	public WordLists(String textFileName) throws IOException {
	    File textFile = new File(textFileName);
	    in = new BufferedReader(new FileReader(textFile));
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
	private List<String> reverseAllWords( Collection<String> argCollection ) {
		List<String> tempList = new LinkedList<String>();
		for ( String word : argCollection ) {
    			word = new StringBuilder(word).reverse().toString(); // Reverse word
    			tempList.add(word); 
		}
    			return tempList;
	}

	// Computes the number of occurrences of a word using the "base" dictionary unsortedDict.
	// After calling, unsortedDict contains words (that are unsorted due to HashMap) mapped
	// to their respective number of occurrences.
	private void computeWordFrequencies() throws IOException{
	    String word;
	    while ( (word = getWord()) != null ) {
	    		if ( unsortedDict.containsKey(word)) {
	    			unsortedDict.put(word, unsortedDict.get(word) + 1); // Overwrites with new value
	    		}
	    		else
	    			unsortedDict.put(word, 1);
	    }
	}

	// Compute backwards dictionary. No need to care about number of occurrences (see lab descr.)
	private void computeBackwardsOrder() {
		// Two data structures used for computation
		TreeSet<String> workSet = new TreeSet<String>();
		TreeMap<String, Integer> workMap = new TreeMap<String, Integer>();
		
		workMap.putAll(unsortedDict); // Automatically alphabetically sorted
		
		 // A SET of sorted (by last character) words (that are reversed):
		workSet.addAll(reverseAllWords(workMap.keySet()));
		
		// A LIST of sorted (by last character) words (that are not reversed):
		backwardsSortedDict.addAll(reverseAllWords(workSet));
		}
	
	
	// Compute frequency dictionary. 
	private void computeFrequencyMap() {
		// A sorted set, where elements are Map with only one entry each. Comparator
		//class FreqComparator is used to sort according to frequency.
		freqSortedDict = new TreeSet<Map<String, Integer>>(new FreqComparator());
		
		// Determine frequency map
		for ( String word : unsortedDict.keySet() ) {
			workMap.put(word, unsortedDict.get(word)); // fetch word and frequency, create temp HashMap
			
			 // Create new HashMap to avoid using a reference to a Map as element,
			// we want the element to be an actual object. Add element to dictionary.
			freqSortedDict.add(new HashMap<String, Integer>(workMap));
			
			// Clear reference to enable reuse
			workMap.clear();
		}
	}
			
	
	// For printing
	private void printDictToText(String dictionary) throws FileNotFoundException {
		
		switch (dictionary) {
			case "alfaSortedDict": {
				PrintWriter printWriter = new PrintWriter("alfaSorted.txt");
				
				for (String word : alfaSortedDict.keySet())
					printWriter.println(word);
				printWriter.close();
			}
			case "backwardsSortedDict": {
				PrintWriter printWriter = new PrintWriter("backwardsSorted.txt");
				
				for (String word : backwardsSortedDict)
					printWriter.printf("%15s\n", word);
				printWriter.close();
			}
			case "freqSortedDict": {
				PrintWriter printWriter = new PrintWriter("frequencySorted.txt");
				
				int i = 0;
				for (Map<String, Integer> entryMap : freqSortedDict) {
					for (String key : entryMap.keySet()) {
						if ( i != entryMap.get(key) ) {
							i = entryMap.get(key);
							printWriter.println(i + ": ");
						}
						printWriter.println("	" + key);
					}
				}
				printWriter.close();
			}
		}
	}

	
	public static void main(String[] args) {
		try {
		WordLists wl = new WordLists(args[0]);

		// Needed to compute each dictionary type. Instantiates a Set called unsortedDict.
		wl.computeWordFrequencies();
		
		// Convert from HashMap (unsortedDict) to TreeMap (alfaSortedDict) to get alphabetical sorting.
	    wl.alfaSortedDict.putAll(wl.unsortedDict);
	    
	    // Determine backwards dictionary
	    wl.computeBackwardsOrder();

	    // Determine dictionary sorted according to frequency
		wl.computeFrequencyMap();
		
		wl.printDictToText("alfaSortedDict");
		wl.printDictToText("backwardsSortedDict");
		wl.printDictToText("freqSortedDict");
		
		System.out.println("Finished!");
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}



















