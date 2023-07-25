package com.akhi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.entity.StateMaster;

public interface StateRepository extends JpaRepository<StateMaster, Serializable>{
	
	//select * from state_master where countryId=?
          public List<StateMaster> findByCountryId(Integer countryId);
}
