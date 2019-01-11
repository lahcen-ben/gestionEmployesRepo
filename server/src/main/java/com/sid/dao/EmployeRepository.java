package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
}