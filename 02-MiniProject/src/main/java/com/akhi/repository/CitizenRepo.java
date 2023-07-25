package com.akhi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akhi.binding.CitizenPlan;

public interface CitizenRepo extends JpaRepository<CitizenPlan, Integer> {
	//to get unique plannames from table or entity
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames();

	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();

}
