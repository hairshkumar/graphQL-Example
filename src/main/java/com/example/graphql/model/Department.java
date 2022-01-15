package com.example.graphql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "departmentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

	@Column(name = "name")
	private String name;
}