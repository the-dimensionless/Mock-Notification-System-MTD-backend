package com.nagarro.nsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nsys.models.EventTypes;

public interface EventTypesRepository extends JpaRepository<EventTypes, Long> {

}
