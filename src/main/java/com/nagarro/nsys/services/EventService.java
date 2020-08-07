package com.nagarro.nsys.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.models.EventTypes;
import com.nagarro.nsys.repositories.EventRepository;
import com.nagarro.nsys.repositories.EventTypesRepository;

/**
 * Service Layer for Event related activities
 * @author sumitsingh
 *
 */
@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventTypesRepository eventTypesRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private void cancelEventActual(Long eventId) {
		try {
			Event e = this.eventRepository.findById(eventId).get();
			e.setEventStatus(false);
			logger.info("Event with id "+eventId+" is canceled");
			this.eventRepository.save(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Cancels the event with the given event id
	 * @param eventId : Long
	 */
	public void cancelEvent(Long eventId) {
		this.cancelEventActual(eventId);
	}
	
	private List<EventTypes> getEventTypes () {
		try {
			return this.eventTypesRepository.findAll();
		} catch (Exception e) {
			logger.debug("Error while retrieving Event Types");
			System.out.println(e);
			return null;
		}
	}
	
	private boolean addEventType (EventTypes et) {
		try {
			this.eventTypesRepository.save(et);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	private boolean publishEvent (Event event) {
		try {
			this.eventRepository.save(event);
			logger.info("Current Event : " + event.getEventName() + " is saved");
			return true;
		} catch (Exception e) {
			logger.debug("Error has occurred while saving event: " + event.getEventName());
			System.out.println(e);
			return false;
		}
	}
	
	private List<Event> getAllActiveEvents () {
		try {
			List<Event> listOfEvents = this.eventRepository.findByEventStatus(true);
			logger.info("Retrieved : Events that are active! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving event.");
			return null;
		}
	}
	
	private boolean userSubscribesEvent(Long eventId, String emailId, Long phone) {
		
		try {
			Event event = this.eventRepository.getOne(eventId);
			event.addEventEmail(emailId);
			event.addEventPhone(phone);
			this.eventRepository.save(event);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	private boolean userUnsubscribesEvent(Long eventId, String emailId, Long phone) {
		try {
			Event event = this.eventRepository.getOne(eventId);
			event.removeEventEmail(emailId);
			event.removeEventPhone(phone);
			this.eventRepository.save(event);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Unsubscribes a user from a given Event notification list
	 * @param eventId : Long
	 * @param emailId : String
	 * @param phone : Long
	 * @return : boolean
	 */
	public boolean userUnsubscribes(Long eventId, String emailId, Long phone) {
		return this.userUnsubscribesEvent(eventId, emailId, phone);
	}
	
	/**
	 * Subscribes a user and adds details to event notification list
	 * @param eventId : Long
	 * @param emailId : String
	 * @param phone : Long
	 * @return : boolean
	 */
	public boolean userSubscribe(Long eventId, String emailId, Long phone) {
		return this.userSubscribesEvent(eventId, emailId, phone);
	}
	
	/**
	 * Saves an event using event repository
	 * @param event : Event
	 * @return : boolean
	 */
	public boolean addEvent (Event event) {
		return this.publishEvent(event);
	}
	
	/**
	 * Retrieves a list of active Events
	 * @return : List<Event>
	 */
	public List<Event> getActiveEventsList () {
		return this.getAllActiveEvents();
	}
	
	/**
	 * Returns a list of all different Event Types
	 * @return : List<EventTypes>
	 */
	public List<EventTypes> getAllEventTypes() {
		return this.getEventTypes();
	}
	
	/**
	 * Saves an event type using event type repository
	 * @param et : EventTypes
	 * @return : boolean
	 */
	public boolean saveEventType (EventTypes et) {
		return this.addEventType(et);
	}
	
	/**
	 * Retreives a sample Event by Id
	 * <p>Used only for testing purposes</p>
	 * <p>NOT PART OF ACTUAL WORKING SOFTWARE</p>
	 * @param id : Long
	 * @return : Event
	 */
	public Event getTest(Long id) {
		return this.eventRepository.getOne(id);
	}
}
