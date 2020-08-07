package com.nagarro.nsys.taskFactory;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.services.communication.MailService;
import com.nagarro.nsys.services.communication.SMSService;
import com.nagarro.nsys.tasks.Observer;

public interface ObserverFactory {
	
	/**
	 * Creates and returns an Observer class.
	 * @param evt : Event
	 * @param sms : SMSService
	 * @param ms : MailService
	 * @return : Observer
	 */
	public Observer getObserver(Event evt, SMSService sms, MailService ms);

}
