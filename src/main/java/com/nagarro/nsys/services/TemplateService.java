package com.nagarro.nsys.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nsys.models.MailTemplate;
import com.nagarro.nsys.models.SmsTemplate;
import com.nagarro.nsys.models.Template;
import com.nagarro.nsys.repositories.MailTemplateRepository;
import com.nagarro.nsys.repositories.SmsTemplateRepository;
import com.nagarro.nsys.repositories.TemplateRepository;

/**
 * Service Layer for all Template related actions.
 * @author sumitsingh
 *
 */
@Service
public class TemplateService {

	@Autowired
	TemplateRepository templateRepository;
	
	@Autowired
	MailTemplateRepository mailRepository;
	
	@Autowired
	SmsTemplateRepository smsRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private boolean addMailTemplate (MailTemplate mt) {
		try {
			this.mailRepository.save(mt);
			logger.info("Current Template : " + mt.getTemplateDescription() + " is saved");
			return true;
		} catch (Exception e) {
			logger.debug("Error has occurred while saving event: " + mt.getTemplateDescription());
			System.out.println(e);
			return false;
		}
	}
	
	private boolean addSmsTemplate (SmsTemplate st) {
		try {
			this.smsRepository.save(st);
			logger.info("Current Template : " + st.getTemplateDescription() + " is saved");
			return true;
		} catch (Exception e) {
			logger.debug("Error has occurred while saving event: " + st.getTemplateDescription());
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Saves a new Mail Template
	 * @param mt : MailTemplate
	 * @return : boolean
	 */
	public boolean saveNewMailTemplate (MailTemplate mt) {
		return this.addMailTemplate(mt);
	}
	
	/**
	 * Saves a new Sms Template
	 * @param st : SmsTemplate
	 * @return : boolean
	 */
	public boolean saveNewSmsTemplate (SmsTemplate st) {
		return this.addSmsTemplate(st);
	}
	
	private List<Template> getAllTemplates () {
		try {
			List<Template> listOfEvents = this.templateRepository.findAll();
			logger.info("Retrieved : Templates! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving templates.");
			return null;
		}
	}
	
	private List<MailTemplate> getMailTemplatesById (Long templateId) {
		try {
			List<MailTemplate> listOfEvents = this.mailRepository.findByTemplateId(templateId);
			logger.info("Retrieved : Email Templates! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving email templates.");
			return null;
		}
	}
	
	private List<MailTemplate> getMailTemplates () {
		try {
			List<MailTemplate> listOfEvents = this.mailRepository.findAll();
			logger.info("Retrieved : Email Templates! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving email templates.");
			return null;
		}
	}
	
	private List<SmsTemplate> getSmsTemplatesById (Long templateId) {
		try {
			List<SmsTemplate> listOfEvents = this.smsRepository.findByTemplateId(templateId);
			logger.info("Retrieved : Sms Templates! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving sms templates.");
			return null;
		}
	}
	
	private List<SmsTemplate> getSmsTemplates () {
		try {
			List<SmsTemplate> listOfEvents = this.smsRepository.findAll();
			logger.info("Retrieved : Sms Templates! ");
			return listOfEvents;
		} catch (Exception e) {
			System.out.println(e);
			logger.debug("Error has occurred while saving retrieving sms templates.");
			return null;
		}
	}
	
	/**
	 * Retrieved all templates from repository
	 * @return : List<Templates>
	 */
	public List<Template> getTemplates () {
		return this.getAllTemplates();
	}
	
	/**
	 * Retrieves Mail Template by Id from repository
	 * @param templateId : Long
	 * @return : List<MailTemplate>
	 */
	public List<MailTemplate> getAllMailTemplates (Long templateId) {
		return this.getMailTemplatesById(templateId);
	}
	
	/**
	 * Retrieves all Mail Templates from repository
	 * @return : List<MailTemplate>
	 */
	public List<MailTemplate> getAllMailTemplates () {
		return this.getMailTemplates();
	}
	
	/**
	 * Retrieves Sms Template by template Id
	 * @param templateId : Long
	 * @return : List<SmsTemplate>
	 */
	public List<SmsTemplate> getAllSmsTemplates (Long templateId) {
		return this.getSmsTemplatesById(templateId);
	}
	
	/**
	 * Retrieved all Sms Templates
	 * @return : List<SmsTemplate>
	 */
	public List<SmsTemplate> getAllSmsTemplates () {
		return this.getSmsTemplates();
	}
	
}
