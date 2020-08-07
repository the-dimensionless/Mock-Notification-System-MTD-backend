package com.nagarro.nsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nsys.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
