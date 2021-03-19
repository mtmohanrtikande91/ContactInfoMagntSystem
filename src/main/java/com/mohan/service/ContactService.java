package com.mohan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohan.model.Contact;
import com.mohan.repository.ContactRepository;

//defining the business logic  
@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactsRepository;

//getting all Contact record by using the method findaAll() of CrudRepository  
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contactsRepository.findAll().forEach(contact1 -> contacts.add(contact1));  
		return contacts;
	}

//getting a specific record by using the method findById() of CrudRepository  
	public Contact getContactById(int id) {
		return contactsRepository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Contact contact) {
		contactsRepository.save(contact);
	}

//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id) {
		contactsRepository.deleteById(id);
	}

//updating a record  
	public void update(Contact contact, int contactId) {
		contactsRepository.save(contact);
	}
}