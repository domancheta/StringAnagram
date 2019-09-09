package org.examples;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AnagramFinderTest {

	Dictionary dictionaryMock;
	AnagramFinder finder;
	
	@Before 
	public void setup() {
		dictionaryMock = mock(Dictionary.class);
		finder = new AnagramFinder(dictionaryMock);
		dictionaryMock.addWord("work");
		dictionaryMock.addWord("king");
		
	}
	
	// test empty dictionary returns no values
	@Test
	public void testEmptyDictionary() {
		assertEquals(0, finder.findWords("working").size());
	}
	
	@Test
	public void verifyDictionaryMatchMethodInvocations() {
		finder.findWords("working");
		verify(dictionaryMock, times(13699)).isEnglishWord("working");
		//assertEquals(0, dictionaryMock.size());
	}
	
	// test finding of several added keywords for the word
	@Test
	public void wordsFoundInDictionary() {
		Dictionary d = new Dictionary();
		d.addWord("work");
		d.addWord("king");
		finder = new AnagramFinder(d);	
		assertEquals(2, finder.findWords("working").size());
	}
	
	// test empty source word to find on - this uncovered a Stack Overflow error
	@Test
	public void testEmptySourceWord() {
		Dictionary d = new Dictionary();
		d.addWord("work");
		d.addWord("king");
		finder = new AnagramFinder(d);	
		assertEquals(0, finder.findWords("").size());
	}	
	
	// test source word that has no words found in dictionary
	@Test
	public void testNoMatchesInDictionary() {
		Dictionary d = new Dictionary();
		d.addWord("work");
		d.addWord("king");
		d.addWord("words");
		finder = new AnagramFinder(d);	
		assertEquals(0, finder.findWords("zzzzzz").size());
	}	
	
	// test finding of only one word in dictionary
	@Test
	public void testOneWordMatch() {
		Dictionary d = new Dictionary();
		d.addWord("work");
		finder = new AnagramFinder(d);	
		assertEquals(2, finder.findWords("working").size());
	}	
	
	// test single character words are not in dictionary (this fails with current word extruder algorithm
	// not implemented currently in the WordExtruder algo, but should be put in there
	
	// since I'm not familiar with Mockito, I did not exercise any of the tests here
	// todo: add more method invocation tests, verification of method invocation order
	
	
}
