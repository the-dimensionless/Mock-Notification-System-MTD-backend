package com.nagarro.nsys.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.services.communication.MailService;
import com.nagarro.nsys.services.communication.SMSService;
import com.nagarro.nsys.taskFactory.ObserverFactory;

/**
 * Service Layer for performing all the 
 * <p>Threading activites.</p>
 * @author sumitsingh
 *
 */
@Service
public class ThreadService {

	@Autowired
	private ThreadPoolTaskExecutor et;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	ObserverFactory observerFactory;
	
	@Autowired
	private SMSService sms;
	
	@Autowired
	private MailService ms;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
		/**
		 * <p>Observer that is scheduled to run every 60seconds</p>
		 * <p>and observes the events that are scheduled for today</p>
		 * <p>and executes them as asynchronous tasks using ThreadPoolTaskExecutor</p>
		 */
		@Scheduled(initialDelay = 1000, fixedRate = 60000)
		public void observer () {
			LocalDate current = LocalDate.now();
			LOGGER.info("\n\nObserver Thread on the watch");
			
			List<Event> st = this.eventService.getActiveEventsList()
					.stream().filter(evt->evt.getEventDateTime().isEqual(current)).collect(Collectors.toList());
					
			System.out.println("\nNumber of active events is "+ st.size()+"\n");
			
			if (st != null && st.size() > 0 ) {
				st.forEach(evt->{
					this.et.execute(this.observerFactory.getObserver(evt, sms, ms));
					this.eventService.cancelEvent(evt.getEventId());
					System.out.println("Must execute Task: "+evt.getEventName());
				});
				
			}
			
		}
		
}
