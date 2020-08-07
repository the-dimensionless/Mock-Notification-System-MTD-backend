package com.nagarro.nsys.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "sms_template")
public class SmsTemplate extends Template {
	
	@Column(name="sms_body")
	private String smsBody;

	public String getSmsBody() {
		return smsBody;
	}

	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}

	public SmsTemplate(Long templateId, String templateDescription, String smsBody) {
		super(templateId, templateDescription);
		this.smsBody = smsBody;
	}	
	
	public SmsTemplate () {
		super();
	}
	
}
