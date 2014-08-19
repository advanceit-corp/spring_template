package org.advanceit.calcv2.template.quote.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * QuoteExceptionHandler class
 * 
 * <P>This class is used to take exception handling out of the specific class scope 
 * 	  and make it global (needed if we want to put custom exception into separate package, otherwise it should be
 *    a part of the class that is using it). @ControllerAdvice annotation makes it possible to implement global
 *    error handling.
 * 
 * @author MPyvovarov
 */
@ControllerAdvice
class QuoteExceptionHandler {
	
	/**
	 * Exception handler catches an exception of the specific type thrown by the method.
	 * Because of the annotation @ExceptionHandler(QuoteNotFoundException.class) this method is 
	 * able to catch exception to the type QuoteNotFoundException.class
	 * 
	 * @param ex (required)
	 */
	@ExceptionHandler(QuoteNotFoundException.class)
	public ModelAndView handleQuoteException(QuoteNotFoundException ex) {
 
		ModelAndView model = new ModelAndView("error/quote_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
 
		return model;
	}
	
	/**
	 * Exception handler catches an exception of the specific type thrown by the method.
	 * Because of the annotation @ExceptionHandler(QuotesNotFoundException.class) this method is 
	 * able to catch exception to the type QuotesNotFoundException.class
	 * 
	 * @param ex (required)
	 */
	@ExceptionHandler(QuotesNotFoundException.class)
	public ModelAndView handleQuotesException(QuotesNotFoundException ex) {
 
		ModelAndView model = new ModelAndView("error/quote_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
 
		return model;
	}
}
