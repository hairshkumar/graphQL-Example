package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.model.Employee;
import com.example.graphql.repo.EmployeeRepository;

@Service
public class EmployeeManagamentService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public Employee getEmployeeDetailsById(int employeeId) {
		return employeeRepo.findById(employeeId).orElse(null);
	}

	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee updatedEmployee) {
		return employeeRepo.save(updatedEmployee);
	}

	public Employee createEmployee(Employee employee) {		
		return employeeRepo.save(employee);
	}

	public void deleteEmployeeDetailsById(String employeeId) {
		employeeRepo.deleteById(Integer.valueOf(employeeId));
	}
}
