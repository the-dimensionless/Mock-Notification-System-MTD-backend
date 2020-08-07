package com.nagarro.nsys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nsys.models.SmsTemplate;

@Repository
public interface SmsTemplateRepository extends JpaRepository<SmsTemplate, Long>{

	List<SmsTemplate> findByTemplateId (Long templateId);
}
