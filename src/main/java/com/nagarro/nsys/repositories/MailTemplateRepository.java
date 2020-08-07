package com.nagarro.nsys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nsys.models.MailTemplate;

public interface MailTemplateRepository extends JpaRepository<MailTemplate, Long> {

	List<MailTemplate> findByTemplateId (Long templateId);
}
