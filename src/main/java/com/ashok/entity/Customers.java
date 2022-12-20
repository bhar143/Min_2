package com.ashok.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CUSTOMER_DTS")
public class Customers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CUSTOMER_NAME")
	private String name;
	
	@Column(name="CUSTOMER_EMAIL")
	private String email;
	
	@Column(name="CUSTOMER_GENDER")
	private String gender;
	
	@Column(name="CUSTOMER_NUM")
	private Long num;
	
	@Column(name="CUSTOMER_SSN")
	private Long ssn;

}
