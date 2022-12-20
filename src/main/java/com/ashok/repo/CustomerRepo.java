package com.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.entity.Customers;


@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long>{

}
