package com.akhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhi.Binding.Contact;
import com.akhi.Repository.ContactRepo;
@Service
public class ContactServiceImpl implements ContactService {
     @Autowired
	private ContactRepo repo;
	@Override
	public String saveContact(Contact contact) {
		repo.save(contact);
		if(contact.getContactId()!=null) {
			return "contact saved successfully";
		}else {
		return "failed to save";
	}
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		Contact contact2 = repo.save(contact);
		if(contact.getContactId()!=null) {
			return "updated contactnum";
		}
			return null;
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if(repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "record deleted";
		}else {
			return "no record found";
		}
		
}
}
