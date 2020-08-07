package com.nagarro.nsys.services.communication;

import java.util.List;

/**
 * Service Layer for delivering Emails.
 * @author sumitsingh
 *
 */
public interface MailService {

	/**
	 * Sends Email to all the recipients.
	 * @param mails : List<String>
	 * @param subject : String
	 * @param msg : String
	 * @throws Exception
	 */
	public void sendEmail(List<String> mails, String subject, String msg) throws Exception;

}
