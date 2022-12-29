package com.ashok.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashok.entity.Customers;


@Repository
public interface CustomerRepo extends JpaRepository<Customers, Serializable>{
	
	@Query("select distinct(planName) from Customers")
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from Customers")
	public List<String> getPlanStatues();

}
