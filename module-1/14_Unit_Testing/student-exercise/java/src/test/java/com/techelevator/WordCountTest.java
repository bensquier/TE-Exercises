package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordCountTest {
	
	 WordCount wordCount = new WordCount();
	 
	
	@Test
	public void word_count_returns_a_string_and_the_amount_of_times_it_appears_in_the_array() {
		String[] array1 = {"ba", "ba", "black", "sheep"};
		String[] array2 = {"a", "b", "c", "b"};
		String[] array3 = {};
		String[] array4 = {"c", "b", "a"};
		
		 Map<String, Integer> result1 = wordCount.getCount(array1);
		 Map<String, Integer> result2 = wordCount.getCount(array2);
		 Map<String, Integer> result3 = wordCount.getCount(array3);
		 Map<String, Integer> result4 = wordCount.getCount(array4);
		
		 assertEquals(result1, wordCount.getCount(array1));
		 assertEquals(result2, wordCount.getCount(array2));
		 assertEquals(result3, wordCount.getCount(array3));
		 assertEquals(result4, wordCount.getCount(array4));
		
	}
}
