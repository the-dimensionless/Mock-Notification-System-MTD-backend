package com.nagarro.nsys.taskFactory;

import org.springframework.stereotype.Component;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.services.communication.MailService;
import com.nagarro.nsys.services.communication.SMSService;
import com.nagarro.nsys.tasks.Observer;

@Component
public class ObserverFactoryImpl implements ObserverFactory {
	
	@Override
	public Observer getObserver(Event s, SMSService sms, MailService ms) {
		return new Observer(s, sms, ms);
	}

}
