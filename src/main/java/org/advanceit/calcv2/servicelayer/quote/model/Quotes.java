package org.advanceit.calcv2.template.quote.model;

import java.util.Map;

/**
 * Quotes class
 * 
 * <P>Example of the wrapper class
 *    
 * @author MPyvovarov
 */

public class Quotes {

	private Map<String, Quote> qts;
	
	public Quotes() {
		
	}
	
	public Quotes(Map<String, Quote> qts) {
		this.qts = qts;
	}

	public Map<String, Quote> getQts() {
		return qts;
	}

	public void setQts(Map<String, Quote> qts) {
		this.qts = qts;
	}
}
