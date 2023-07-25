package com.akhi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable>{
              //select * from user_master where email=given mail
	public User findByEmail(String email);
}
