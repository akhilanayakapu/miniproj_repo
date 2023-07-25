package com.akhi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.entity.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, Serializable>{
             public List<CityMaster> finfByStateId(Integer stateId);
}
