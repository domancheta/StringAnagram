package org.examples;

import java.util.HashMap;

// borrowed and converted from javascript
// from https://stackoverflow.com/questions/2439412/algorithm-to-generate-all-possible-letter-combinations-of-given-string-down-to-2/13717469#13717469https://stackoverflow.com/questions/2439412/algorithm-to-generate-all-possible-letter-combinations-of-given-string-down-to-2/2439952#2439952

public class WordExtruder {
	  HashMap<String, String> result = new HashMap<String, String>();
		
	  public HashMap<String, String> getWordsNew (String masterword) {
		
	    String[] a;  
		int  i, l; 
		
	    
	    a = masterword.split("");
	    l = a.length;

	    for (i = 0; i < a.length; i++) {
	    	result.put(a[i], "");

	       nextLetter(a, l, a[i], "" + i);
	    }
		  
	  
	    return result;
	  }
	  
      private void nextLetter(String[] a,  
			                    int l, String key, String used) {
		  int i;
		  
		  if (key.length() == l) {
			  return;
		  }
		  
		  for (i = 0; i < l; i++) {
			  if (used.indexOf("" + i) < 0) {
	              result.put(key + a[i], "");
	              nextLetter (a, l, key + a[i], used + i);
	          }
		  }
      }
		  

	  public static void main (String args[]) {
	    WordExtruder w = new WordExtruder();
	    HashMap <String, String> wordcombos = w.getWordsNew(args[1]);
	    
	    //System.out.println(wordcombos.size());
		for (String key : wordcombos.keySet()) {
			System.out.println(key);
		}
	  }
}
