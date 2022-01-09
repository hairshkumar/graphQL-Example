package com.example.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
