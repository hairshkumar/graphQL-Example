package com.example.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
