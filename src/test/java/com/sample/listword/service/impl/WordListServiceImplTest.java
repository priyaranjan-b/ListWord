package com.sample.listword.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sample.listword.doman.WordCount;

/**
 * This test case will cover implementation of {@link WordListServiceImpl}
 *
 */
public class WordListServiceImplTest {
	
	private WordListServiceImpl service;
	
	@Before
	public void setUp(){
		service = new WordListServiceImpl();
	}
	
	@Test
	public void getWordListWithCount(){
		String testData= "This is a test input for a program:22 $$ history, one two#two or, three*three*three four!four!four!four story";
		List<WordCount> results = service.getWordListWithCount(testData);
		assertEquals("List size should be 15",15, results.size());
		assertEquals("List element shoud be 22","22", results.get(0).getWord());
	}
	
	@Test
	public void getWordListWithCount_NULLCheck(){
		String testData= null;
		List<WordCount> results = service.getWordListWithCount(testData);
		assertNotNull(results);
		assertEquals("List size should be 0",0, results.size());
	}
	
	@Test
	public void getWordListWithCount_EmptyString(){
		String testData= "      ";
		List<WordCount> results = service.getWordListWithCount(testData);
		assertNotNull(results);
		assertEquals("List size should be 0",0, results.size());
	}

}
