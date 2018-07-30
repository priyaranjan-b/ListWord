package com.sample.listword.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sample.listword.doman.WordCount;
import com.sample.listword.service.WordListService;

@Service
public class WordListServiceImpl implements WordListService {
	
	private static final Logger LOGGER = Logger.getLogger(WordListServiceImpl.class);
	
	/** This is the pattern used to split the sentences into words */
	private static String split_pattern ="\\W+";

	public List<WordCount> getWordListWithCount(String sentence){
		LOGGER.info("Processing sentence : "+sentence);
		if(StringUtils.isBlank(sentence)) return Collections.emptyList();
		
		//TreeMap will sort the keys (word) in ascending order, hence no need to sort 
		Map<String, Integer> map = new TreeMap<>();
		Stream.of(sentence.split(split_pattern))
		.filter(StringUtils::isNotEmpty)
		.forEach(word -> {
			Integer count = map.get(word);
			map.put(word, (count == null) ? 1 : count + 1);
		});
		
		//This will convert the Map into list of WordCount Object in same order
		return map.entrySet().stream()
				.map(set -> new WordCount(set.getKey(), set.getValue()))
				.collect(Collectors.toList());
	}
}
