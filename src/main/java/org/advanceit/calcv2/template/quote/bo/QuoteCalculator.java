package org.advanceit.calcv2.template.quote.bo;

import org.advanceit.calcv2.template.quote.model.Quote;

/**
 * QuoteCalculator class
 * 
 * <P>Example of the BO object that encapsulates business logic of the application
 *    
 * @author MPyvovarov
 */
public class QuoteCalculator {

	public Quote calculateQuote(double subtractedAmt) {
		
		Quote qt = new Quote("qt1", 25.0 - subtractedAmt);
		return qt;
	}
	
	
}
