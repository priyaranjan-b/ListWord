package com.sample.listword.service;

import java.util.List;

import com.sample.listword.doman.WordCount;

/**
 * This service is intended  for manipulating input string 
 * to expected output  
 */
public interface WordListService {

	/**
	 * This method takes {@link String} input parameter and 
	 * splits them in based on SPACE and special character
	 * and returns   {@link List} of {@link WordCount}
	 * @param sentence of type  {@link String}
	 * @return {@link List} of {@link WordCount}
	 */
	List<WordCount> getWordListWithCount(String sentence);
}
