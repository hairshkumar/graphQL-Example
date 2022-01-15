package com.example.graphql.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.exception.InvalidEmployeeException;
import com.example.graphql.model.Employee;
import com.example.graphql.repo.EmployeeRepository;

@Component
public class GraphQLMutationService implements GraphQLMutationResolver {

//	@Autowired
//	private EmployeeManagamentService employeeRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		System.out.println("Employee input " + employee);
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {

		System.out.println(employee);
		Employee emp = null;
		if (Objects.nonNull(employee)) {
			boolean isEmployeePresent = employeeRepository.existsById(employee.getId());
			System.out.println(isEmployeePresent);
			if (!isEmployeePresent) {
				throw new InvalidEmployeeException("Employee Details not found in database", employee.getId());
			} else {
				emp = employeeRepository.save(employee);
			}
		}
		return emp;
	}

}
