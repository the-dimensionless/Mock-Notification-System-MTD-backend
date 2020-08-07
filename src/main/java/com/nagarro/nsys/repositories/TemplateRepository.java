package com.nagarro.nsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nsys.models.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{

}
