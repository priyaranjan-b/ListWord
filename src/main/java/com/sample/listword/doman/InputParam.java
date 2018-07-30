package com.sample.listword.doman;

import org.hibernate.validator.constraints.NotEmpty;

public class InputParam {
	
	@NotEmpty(message="Please provide some input value")
	private String sentence;
	
	/**
	 * Default Constructor
	 */
	public InputParam() {}
	
	/**
	 * This constructor takes sentence as input parameter
	 * @param sentence of type {@link String} 
	 */
	public InputParam(String sentence) {
		this.sentence = sentence;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	@Override
	public String toString() {
		return "InputParam [sentence=" + sentence + "]";
	}
	
	

}
