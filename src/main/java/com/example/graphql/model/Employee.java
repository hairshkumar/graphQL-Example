package com.example.graphql.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "jobTitle")
	private String jobTitle;

	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "joinedDate")
	private String joinedDate;

	@Column(name = "gender")
	private String gender;

	@Column(name = "salary")
	private Integer salary;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentid",referencedColumnName = "departmentid")
	private Department department;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "projectid",referencedColumnName = "projectid")
	private Project project;

}
