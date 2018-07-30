package com.sample.listword.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.listword.doman.InputParam;
import com.sample.listword.doman.WordCount;
import com.sample.listword.service.WordListService;
 
/**
 * 
 *This controller provides default page mapping to and end point to process input string
 */
@Controller
public class WordListController {
	
	private static final Logger LOGGER = Logger.getLogger(WordListController.class);
	
	@Autowired
	private WordListService wordListService;
 
    /**
     * This method will return welcome.jsp page
     * @param model
     * @return of type  {@link String}
     */
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String loadWelcomePage(ModelMap model) {
        model.addAttribute("inputParam", new InputParam(""));
        LOGGER.info("Loading welcome page");
        return "welcome";
    }
	
    /**
     * This method of take String as input and split that string to words 
     * also keeps the frequency of the word used in the given string
     * @param inputParam {@link InputParam}
     * @param result of type  {@link BindingResult}
     * @return {@link ModelAndView}
     */
    @RequestMapping(value="/processSentence",method = RequestMethod.POST)
    public ModelAndView processSentence(@Valid @ModelAttribute("inputParam") InputParam inputParam,
    		BindingResult result){
    	
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("welcome");
    	
    	//If there is validation error in the input file return to the jsp page to
    	// display error message
    	if(result.hasErrors()){
            LOGGER.error("Encountered validation error in the input data");
    		return mv;
    	}
    	List<WordCount> wordSortedByName = wordListService.getWordListWithCount(inputParam.getSentence());
    	
    	//Sort the list based on frequency of word used in desc order
    	List<WordCount> wordSortedByCount = new ArrayList<>(wordSortedByName);
    	wordSortedByCount.sort((o1,o2)-> o2.getCount().compareTo(o1.getCount()));
    	
    	mv.addObject("wordSortedByName",wordSortedByName);
    	mv.addObject("wordSortedByCount",wordSortedByCount);

    	return mv;
    }
    
    
 
}