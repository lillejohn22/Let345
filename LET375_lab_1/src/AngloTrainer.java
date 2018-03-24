// Author(s): Anton Frigård and Johan Nilsson
// Email: frigard@student.chalmers.se, nilssojo@student.chalmers.se
// Date:	 2018-03-21

import java.io.*;
import java.util.*;

public class AngloTrainer {
	
	// Instance variables
	private TreeSet<String> dictSet = new TreeSet<String>(), apprWordsSet = new TreeSet<String>();

	private boolean testInput, setContainsWord;
	
	// Constructor method
	public AngloTrainer(String dictFileName) throws IOException, FileNotFoundException {
			loadDictionary(dictFileName);
	}

	// Prints out dictionary
	private void dumpDict(TreeSet<String> tempSet) {
		for(String temp : tempSet)
			System.out.println(temp);
	}
	
	// Load a dictionary from a file
	private void loadDictionary( String fileName ) throws FileNotFoundException, IOException{
		File dictfile = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(dictfile));
		String word;
		while((word = reader.readLine()) != null)
			dictSet.add(word);
		reader.close();
	}
	
	// Find the longest word in a dictionary
	private int findLongestWord(TreeSet<String> tempSet) {
		int a = 0;
		for (String temp : tempSet)
			a = temp.length() > a ? temp.length() : a;
		
		return a;
	}
	
	// Sort the letters in a word alphabetically
	private String sort(String unsortedString) {
		char[] tempCharArray = unsortedString.toCharArray();
		Arrays.sort(tempCharArray);
		
		return String.valueOf(tempCharArray);
	}

	private String randomLetters( int length ) {
		Random randomGenerator = new Random();
	    // this makes vovels a little more likely
	    String letters = "aabcdeefghiijklmnoopqrstuuvwxyyz";  
	    StringBuffer buf = new StringBuffer(length);
	    for ( int i = 0; i < length; i++ ) 
		    buf.append( letters.charAt(randomGenerator.nextInt(letters.length())));
	
	    return buf.toString();
	}

	// Compute a set of words which are combined by random letters
	private void findApprWords(String sortedRandomLetters){
		for (String temp : dictSet)
			if ( includes(sortedRandomLetters,sort(temp)) )
				apprWordsSet.add(temp);
	}
	
	//
	private boolean includes( String a, String b ) {
		if ( b == null || b.length() == 0 )
			return true;
		else if ( a == null || a.length() == 0 )
			return false;
		
		//precondition: a.length() > 0 && b.length() > 0
		int i = 0, j = 0;
		while ( j < b.length() ) {
			if (i >= a.length() || b.charAt(j) < a.charAt(i))
				return false;
			else if (b.charAt(j) == a.charAt(i)) {
				i++; j++;
			} else if (b.charAt(j) > a.charAt(i))
				i++;
		}
		//postcondition: j == b.length()
		return true;
	}

    public static void main(String[] args) {
    		try {
    		AngloTrainer trainer = new AngloTrainer("dictionary.txt");
    		
    		int maxLength = trainer.findLongestWord(trainer.dictSet); // Find length of longest word
    		String randomLetters = trainer.randomLetters(maxLength); // Compute random letters
    		trainer.findApprWords(trainer.sort(randomLetters)); // Determine words that can be combined with randomLetters
 
    		System.out.println("The random letters are: " + randomLetters);
    		System.out.println("Try to build as many words from these letters as you can!");

    		try {
    		Scanner scanner = new Scanner(System.in);
    		String suggestedWord;

    		do {
			suggestedWord = scanner.nextLine();
    			// Checks if letters and number of letters are valid
    			trainer.testInput = trainer.includes(trainer.sort(randomLetters),trainer.sort(suggestedWord)); 
    			// Check if word is in the dictionary
    			trainer.setContainsWord = trainer.apprWordsSet.contains(suggestedWord);
    			
    			if ( trainer.testInput && trainer.setContainsWord ) {
    				System.out.println("ok!");
    				trainer.apprWordsSet.remove(suggestedWord);
    			}else {
    				if ( !trainer.testInput && !trainer.setContainsWord)
    					System.out.println("You used illegal letters or too many and the word was not in the dictionary");
    				else if (!trainer.testInput)
    					System.out.println("You used illegal letters or too many");
    				else
        				System.out.println("The word is not in the dictionary");
    				trainer.dumpDict(trainer.apprWordsSet);
    				break;
    			}
    		} while (trainer.testInput && trainer.setContainsWord);
    		
    		scanner.close(); // Interaction is interrupted by faulty word or user shutdown
    		}
    		catch (NoSuchElementException e) { // Thrown by scanner.nextLine()
    			trainer.dumpDict(trainer.apprWordsSet); // If session is interrupted by user
    		}
    		}
    		catch (IOException e) {
    			System.out.println(e);
    		}
    }
}













