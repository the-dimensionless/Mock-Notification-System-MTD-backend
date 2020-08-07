package com.nagarro.nsys.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "mail_template")
public class MailTemplate extends Template {

	@Column(name="mail_body")
	private String mailBody;

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public MailTemplate(Long templateId, String templateDescription, String mailBody) {
		super(templateId, templateDescription);
		this.mailBody = mailBody;
	}

	public MailTemplate () {
		super ();
	}
	
}
