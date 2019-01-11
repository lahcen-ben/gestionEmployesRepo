package com.sid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.dao.EmployeRepository;
import com.sid.model.Employe;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	public EmployeService(EmployeRepository employeRepository) {
		this.employeRepository = employeRepository;
	}

	public Iterable<Employe> list() {
		return employeRepository.findAll();
	}

	public Iterable<Employe> save(List<Employe> employes) {
		return employeRepository.save(employes);
	}
	
	public Employe save(Employe e) {
		return employeRepository.save(e);
	}
	
	public void delete(long id) {
		employeRepository.delete(id);
	}
	
	public Employe getEmploye(long id) {
		return employeRepository.getOne(id);
	}

}
