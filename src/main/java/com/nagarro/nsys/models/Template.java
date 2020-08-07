package com.nagarro.nsys.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name = "template")
@Inheritance(
		strategy = InheritanceType.JOINED
)
public class Template {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="template_id")
	private Long templateId;
	
	@Column(name="template_description")
	private String templateDescription;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public Template(Long templateId, String templateDescription) {
		super();
		this.templateId = templateId;
		this.templateDescription = templateDescription;
	}
	
	public Template () {
		
	}
	
}
