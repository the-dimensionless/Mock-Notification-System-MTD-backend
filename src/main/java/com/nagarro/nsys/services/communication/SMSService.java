package com.nagarro.nsys.services.communication;

import com.twilio.rest.api.v2010.account.Message;

/**
 * Service Layer for delivering Sms
 * @author sumitsingh
 *
 */
public interface SMSService {
	
	/**
	 * Delivers the text message to recipient using Twilio API
	 * @param number : Long
	 * @param body : String
	 * @return : com.twilio.rest.api.v2010.account.Message
	 */
	public Message sendSMS(Long number, String body);

}