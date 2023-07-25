package com.akhi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.entity.CountryMaster;

public interface CountryRepository extends JpaRepository<CountryMaster, Serializable> {

}
