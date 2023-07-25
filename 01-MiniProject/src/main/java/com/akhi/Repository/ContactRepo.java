package com.akhi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.Binding.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
