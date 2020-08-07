package com.nagarro.nsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nsys.models.Event;
import com.nagarro.nsys.models.EventTypes;
import com.nagarro.nsys.models.MailTemplate;
import com.nagarro.nsys.models.SmsTemplate;
import com.nagarro.nsys.services.EventService;
import com.nagarro.nsys.services.TemplateService;

/**
 * <p>Event Controller for the REST API
 * Contains all the endpoints for </p>
 * Template and Event actions.
 * @author sumitsingh
 *
 */
@RestController
@RequestMapping ("/events")
@CrossOrigin
public class EventsController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	TemplateService templateService;

	/**
	 * Retrives all distict event Types
	 * @return List<EventTypes>
	 */
	@GetMapping
	public List<EventTypes> getAllTemplates () {	// All EventTypes (works)
		return this.eventService.getAllEventTypes();
	}
	
	/**
	 * Saves an Event Type to database
	 * @param et : EventTypes
	 * @return : boolean
	 */
	@PostMapping("/addNew/EventType")
	public boolean saveNewEventType (@RequestBody EventTypes et) {
		return this.eventService.saveEventType(et);
	}
	
	/**
	 * Retrieves Mail Template with given Id
	 * @param id : Long
	 * @return : List<MailTemplate>
	 */
	@GetMapping("/mailTemplates/{id}")
	public List<MailTemplate> getMailTemplates (@PathVariable("id") Long id) {	// All Mail templates
		return this.templateService.getAllMailTemplates(id);
	}
	
	/**
	 * Retreives all Mail Templates
	 * @return : List<MailTemplate>
	 */
	@GetMapping("/mailTemplates/")
	public List<MailTemplate> getMailTemplates () {	// All Mail templates
		return this.templateService.getAllMailTemplates();
	}
	
	/**
	 * POST Request to add a new
	 * <p>mail template</p>
	 * @param mt : MailTemplate
	 * @return : boolean
	 */
	@PostMapping("/mailTemplates")
	public boolean addNewMailTemplate (@RequestBody MailTemplate mt) {	// Add new Mail Template 
		return this.templateService.saveNewMailTemplate(mt);
	}
	
	/**
	 * GET Request to retrieve
	 * <p>Sms Templates with given Id.</p>
	 * @param id : Long
	 * @return : List<SmsTemplate>
	 */
	@GetMapping("/smsTemplates/{id}")
	public List<SmsTemplate> getSmsTemplates (@PathVariable("id") Long id) { // All Sms Template (works)
		return this.templateService.getAllSmsTemplates(id);
	}
	
	/**
	 * GET Request to retrieve all Sms Templates
	 * @return : List<SmsTemplate>
	 */
	@GetMapping("/smsTemplates/")
	public List<SmsTemplate> getSmsTemplates () { // All Sms Template (works)
		return this.templateService.getAllSmsTemplates();
	}
	
	/**
	 * POST Request to save a Sms Template
	 * @param st : SmsTemplate
	 * @return : boolean
	 */
	@PostMapping("/smsTemplates")
	public boolean addNewMailTemplate (@RequestBody SmsTemplate st) {	// Add new Sms Template
		return this.templateService.saveNewSmsTemplate(st);
	}
	
	/**
	 * GET Request to retrieve
	 * <p>All Active Events (Scheduled) </p>
	 * @return : List<Event>
	 */
	@GetMapping("/activeEvents")
	public List<Event> getAllActiveEvents () {			// All Active Events (works)
		return this.eventService.getActiveEventsList();
	}
	
	/**
	 * POST Request to save
	 * <p>an Event to the database</p>
	 * @param event : Event
	 * @return : String
	 */
	@PostMapping("/activeEvents")				// Add new Event
	public String publishEvent (@RequestBody Event event) {
		boolean res = this.eventService.addEvent(event);
		return (res == true)? "Added":"Error";
	}
	
	/**
	 * GET Request to cancel
	 * <p>Event with given event id.</p>
	 * @param eventId : Long
	 */
	@GetMapping("/activeEvents/{id}")
	public void cancelEvent(@PathVariable("id") Long eventId) {
		this.eventService.cancelEvent(eventId);
	}
	
	/**
	 * GET Request to retrieve a template with given id.
	 * @param id : Long
	 * @return : ResponseEntity<?>
	 */
	@GetMapping("test/fetch/{id}")
	public ResponseEntity<?> getTemplate(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.eventService.getTest(id));
	}
	
	/**
	 * GET Request to avail user Subscription
	 * @param eventId : Long
	 * @param email : String
	 * @param phone : Long
	 * @return : boolean
	 */
	@GetMapping("subscribe/{id}/{email}/{phone}")
	public boolean userSubscribes(@PathVariable("id") Long eventId, @PathVariable("email") String email,
			@PathVariable("phone") Long phone) {
		return this.eventService.userSubscribe(eventId, email, phone);
	}
	
	/**
	 * GET Request to enable user to unsubscribe.
	 * @param eventId : Long
	 * @param email : String
	 * @param phone : Long
	 * @return : boolean
	 */
	@GetMapping("unsubscribe/{id}/{email}/{phone}")
	public boolean userUnsubscribes(@PathVariable("id") Long eventId, @PathVariable("email") String email,
			@PathVariable("phone") Long phone) {
		return this.eventService.userUnsubscribes(eventId, email, phone);
	}
	
}
