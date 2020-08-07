package com.nagarro.nsys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nsys.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findByEventStatus (Boolean eventStatus);

}
