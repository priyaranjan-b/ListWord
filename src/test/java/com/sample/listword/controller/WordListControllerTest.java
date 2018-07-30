package com.sample.listword.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.sample.listword.controller.WordListController;
import com.sample.listword.doman.InputParam;
import com.sample.listword.doman.WordCount;
import com.sample.listword.service.WordListService;

/**
 * This test case will cover implementation of {@link WordListController}
 *
 */
public class WordListControllerTest {
	
	private WordListController controller;
	@Mock
	private WordListService wordListService;
	
	@Before
	public void setUp(){
		controller = new WordListController();
		MockitoAnnotations.initMocks(this);
		try {
			ReflectionTestUtils.setField(controller, "wordListService", wordListService,WordListService.class);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void processSentence(){
		BindingResult result =	Mockito.mock(BindingResult.class);
		Mockito.when(result.hasErrors()).thenReturn(false);
		
		List<WordCount> wordCountList = new ArrayList<>();
		wordCountList.add(new WordCount("abc",4));
		wordCountList.add(new WordCount("def",5));
		
		Mockito.when(wordListService.getWordListWithCount(Mockito.anyString())).thenReturn(wordCountList);
		ModelAndView mv = controller.processSentence(new InputParam(), result);
		Assert.assertEquals(wordCountList, mv.getModelMap().get("wordSortedByName"));
		
		List<WordCount> wordCountListSortedByCount = new ArrayList<>();
		wordCountListSortedByCount.add(new WordCount("def",5));
		wordCountListSortedByCount.add(new WordCount("abc",4));

		Assert.assertEquals(wordCountListSortedByCount, mv.getModelMap().get("wordSortedByCount"));
	}
	
}
