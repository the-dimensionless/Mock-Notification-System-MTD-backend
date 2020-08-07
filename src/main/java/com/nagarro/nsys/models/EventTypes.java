package com.nagarro.nsys.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "event_types")
public class EventTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "type_id")
	private Long eventTypeId;

	@Column (name = "event_type")
	private String eventType;

	public Long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public EventTypes(Long eventTypeId, String eventType) {
		super();
		this.eventTypeId = eventTypeId;
		this.eventType = eventType;
	}
	
	public EventTypes () {
		
	}
}
