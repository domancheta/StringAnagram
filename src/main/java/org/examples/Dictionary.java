package org.examples;

import java.util.HashMap;

public class Dictionary {

	private HashMap<String, String> dictionary = new HashMap<String, String>();
	
	// for our purposes just create fake dictionary.  This shouldn't be available in the real dictionary object
	public void addWord (String s) {
		dictionary.put(s, "");
	}
	
	public int size() {
		return dictionary.size();
	}
	
	// connect to online dictionary and validate if word is English - to be mocked
	public  boolean isEnglishWord(String s) {
		if (dictionary.containsKey(s))
			return true;
		else return false;
		
	}
}
