package org.advanceit.calcv2.template.service;

import org.advanceit.calcv2.template.quote.bo.QuoteCalculator;
import org.advanceit.calcv2.template.quote.model.Quote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuoteController class
 * 
 * <P>Example of the rest webservice 
 *    
 * @author MPyvovarov
 */

@RestController
public class CalcV2 {
	
	/**
	 * Returns a Json String which is a result of automatic parsing done by spring framework
	 *  @RequestMapping("/calc") annotation maps the return result of this method to /calc page of the app
	 *  @RequestParam allows to pass parameters by GET (from URL) or POST request
	 *
	 * @param       double subtractedAmt - the amount that will be a part of calculation for the quote
	 * @return      Quote object
	*/
	@RequestMapping("/calcV2")
	public Quote getLapster(@RequestParam(value="subtractedAmt", required=false, defaultValue="0.0") double subtractedAmt, 
							@RequestParam(value="addAmt", required=false, defaultValue="0.0") double addAmt) {
		try{
			QuoteCalculator qc = new QuoteCalculator();
			
		    return qc.calculateQuote(subtractedAmt - addAmt);
		} catch (Exception ex) {
			System.out.println("Smth went wrong");
			return new Quote();
		}
	}
	
}
