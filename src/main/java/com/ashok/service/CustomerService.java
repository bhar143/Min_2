package com.ashok.service;

import java.util.List;

import com.ashok.entity.Customers;

public interface CustomerService {
	
	public String addCustomers(Customers customer);
	public List<Customers> getAllCustomers();
	

}
