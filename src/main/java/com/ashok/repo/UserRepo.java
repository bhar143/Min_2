package com.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.entity.User;



public interface UserRepo  extends JpaRepository<User, Long>{

}
