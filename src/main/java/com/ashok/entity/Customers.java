package com.ashok.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Customers {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String planName;
	private String planStatus;
	private String email;
	private String gender;
	private Long num;
	private Long ssn;

}
