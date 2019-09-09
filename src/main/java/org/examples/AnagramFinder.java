package org.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramFinder {


	Dictionary dictionary;
	
	public AnagramFinder(Dictionary d) {
		dictionary = d;
	}
	
	public List<String> findWords(String theWord) {
		
		List<String> validWords = new ArrayList<String>();
	
		// use borrowed algorithm to generate all possible words for a string
	
		HashMap <String, String> allWords = new WordExtruder().getWordsNew(theWord);

		// find all matching words in the dictionary
		for (String currWord : allWords.keySet()) {
			 if (dictionary.isEnglishWord(currWord))
				  validWords.add(currWord);
		}
	
		return validWords;		
		
	}
	
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		d.addWord("working");
		d.addWord("work");
		d.addWord("king");
		d.addWord("kin");
		AnagramFinder ang = new AnagramFinder(d);
		
		List<String> validWords = ang.findWords("working");
		
		
		System.out.println("Found words");
		for (String word : validWords) {
			 System.out.println(word);
		}
	}

}
