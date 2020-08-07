package com.nagarro.nsys.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.services.communication.MailService;
import com.nagarro.nsys.services.communication.SMSService;

/**
 * <p>Class that performs the asynchronous task</p>
 * <p>Of sending emails and messages to all recipients</p>
 * @author sumitsingh
 *
 */
public class Observer implements Runnable {
	
	@Autowired
	private SMSService sms;
	
	@Autowired
	private MailService mailService;
	
	private String status;
	private Event event;
	private List<String> mails;
	private List<Long> phones;
	
	public Observer (Event e, SMSService sms, MailService mailService) {
		this.event = e;
		this.sms = sms;
		this.mailService = mailService;
		this.mails = this.event.getEventEmails();
		this.phones = this.event.getEventPhones();
		
		System.out.println(this.sms);
	}
	
	public String getStatus () {
		return this.status;
	}

	@Override
	public void run() {
		if (this.event.getEventMailBody() != null) {
			try {
				this.mailService.sendEmail(this.mails, this.event.getEventName(), this.event.getEventMailBody());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (this.event.getEventSmsBody() != null) {
			this.phones.forEach(i->{
				this.sms.sendSMS(i, this.event.getEventSmsBody());
				System.out.println("Sent sms successfully to "+i);
			});
		}
		
		System.out.println("\nObserving Performing task duty. . .\n");
		this.status = "Completed successfully";
	}

}
