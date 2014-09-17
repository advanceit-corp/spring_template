package org.advanceit.calcv2.template.service;

import java.io.IOException;

import org.advanceit.calcv2.template.Application;
import org.advanceit.calcv2.template.OauthSessionProvider;
import org.advanceit.calcv2.template.quote.bo.QuoteCalculator;
import org.advanceit.calcv2.template.quote.model.Quote;
import org.apache.http.HttpException;
import org.json.JSONException;
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
			
			Application.log.info("calcv2 from Application");
			
		    return qc.calculateQuote(subtractedAmt - addAmt);
		} catch (Exception ex) {
			System.out.println("Smth went wrong");
			return new Quote();
		}
	}
	
	/**
     * Returns a String. This method is a webservice that is used for authorized requestTesting (SFDC-HEROKU-SFDC)
     *
     * @param       
     * @return      Quote object
    */
	@RequestMapping("/loadTest")
	public String getTestData() throws JSONException {
	  
	      String loginHost = "https://test.salesforce.com/services/oauth2/token"; //different for production
	      String username = "";
	      String password = "";
	      String clientId = "";
	      String secret = "";
	      String securityToken = "";
	      
	      
	      String access_token;
	      String end_point = "https://cs30.salesforce.com/services/apexrest/MaxSfdcHerokuLoadTesterWebService/";
	      
	      try {
	        try {
	          /*We make a request using OauthSessionProvider.oAuthSessionProvider to get an access_token*/
	          access_token = OauthSessionProvider.sendRequestAndGetAccessToken(loginHost, username, password, clientId, secret, securityToken);
	          
	          /*We attach access_token to the request to make an authorized call*/
	          return OauthSessionProvider.sendRequestWithAccessToken(access_token, end_point);

	        } catch (IOException e) {
	          System.out.println("Problems with OauthSessionProvider IOException: " + e);
	          e.printStackTrace();
	          return null;
	        }
	      } catch (HttpException e) {
	        System.out.println("Problems with OauthSessionProvider HttpException: " + e);
	        e.printStackTrace();
	        return null;
	      }
	}
	
}
