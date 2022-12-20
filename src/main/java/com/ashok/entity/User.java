package com.ashok.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER_DTS")
public class User {
	@Column(name="USER_NAME")
	private String planeName;
	
	@Column(name="USER_STATUS")
	private String planeStatus;

}
