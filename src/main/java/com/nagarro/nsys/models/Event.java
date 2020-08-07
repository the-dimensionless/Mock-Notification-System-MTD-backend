package com.nagarro.nsys.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table (name = "event")
@Transactional
public class Event {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private Long eventId;
	
	@Column (name="event_type")
	private String eventType;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_description")
	private String eventDescription;
	
	@Column (name = "mail_body")
	private String eventMailBody;
	
	@Column (name = "sms_body")
	private String eventSmsBody;
	
	@Column (name="event_status")
	private boolean eventStatus;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column (name = "event_date_time")
	public LocalDate eventDateTime;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name ="subscriber_mails")
	private List<String> eventEmails;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name ="subscriber_phones")
	private List<Long> eventPhones;
	
	

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventMailBody() {
		return eventMailBody;
	}

	public void setEventMailBody(String eventMailBody) {
		this.eventMailBody = eventMailBody;
	}

	public String getEventSmsBody() {
		return eventSmsBody;
	}

	public void setEventSmsBody(String eventSmsBody) {
		this.eventSmsBody = eventSmsBody;
	}
	
	public boolean isEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(boolean eventStatus) {
		this.eventStatus = eventStatus;
	}
	
	
	
	//--

	public LocalDate getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(LocalDate eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public List<String> getEventEmails() {
		return eventEmails;
	}

	public void setEventEmails(List<String> eventEmails) {
		this.eventEmails = eventEmails;
	}

	public List<Long> getEventPhones() {
		return eventPhones;
	}

	public void setEventPhones(List<Long> eventPhones) {
		this.eventPhones = eventPhones;
	}
	
	public void addEventEmail(String eventEmail) {
		this.eventEmails.add(eventEmail);
	}
	
	public void addEventPhone(Long phone) {
		this.eventPhones.add(phone);
	}
	
	public void removeEventEmail(String eventEmail) {
		this.eventEmails.remove(eventEmail);
	}
	
	public void removeEventPhone(Long eventPhone) {
		this.eventPhones.remove(eventPhone);
	}

	public Event(Long eventId, String eventType, String eventName, String eventDescription, String eventMailBody,
			String eventSmsBody, boolean eventStatus, LocalDate eventDateTime, List<String> eventEmails,
			List<Long> eventPhones) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventMailBody = eventMailBody;
		this.eventSmsBody = eventSmsBody;
		this.eventStatus = eventStatus;
		this.eventDateTime = eventDateTime;
		this.eventEmails = eventEmails;
		this.eventPhones = eventPhones;
	}

	public Event () {
		
	}

}
