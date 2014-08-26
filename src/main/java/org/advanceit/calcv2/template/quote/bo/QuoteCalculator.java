package org.advanceit.calcv2.template.quote.bo;

import org.advanceit.calcv2.template.Application;
import org.advanceit.calcv2.template.quote.model.Quote;
import org.apache.log4j.Logger;


/**
 * QuoteCalculator class
 * 
 * <P>Example of the BO object that encapsulates business logic of the application
 *    
 * @author MPyvovarov
 */
public class QuoteCalculator {
	
	public static final Logger log = Logger.getLogger(QuoteCalculator.class);

	public Quote calculateQuote(double subtractedAmt) {
		
		log.info("QuoteCalculator");
		Quote qt = new Quote("qt1", 25.0 - subtractedAmt);
		return qt;
	}
	
	
}
