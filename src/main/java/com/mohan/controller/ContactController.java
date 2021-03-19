package com.mohan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohan.model.Contact;
import com.mohan.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {
	@Autowired
	ContactService contactService;

	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		System.out.println("In greteen");
		model.addAttribute("name", name);
		
		return "greeting";
	}

	
	@GetMapping("/getContact")
	private List<Contact> getAllContact() {
		return contactService.getAllContacts();
	}

	@GetMapping("/contact/{contactId}")
	private Contact getContact(@PathVariable("contactId") int contactId) {
		return contactService.getContactById(contactId);
	}

	@DeleteMapping("/deleteContact/{contactId}")
	private void deleteContact(@PathVariable("contactId") String contactId) {
		contactService.delete(Integer.parseInt(contactId));
	}

	@PostMapping("/saveContact")
	private int saveContact(@RequestBody Contact contact) {
		contactService.saveOrUpdate(contact);
		return contact.getContactId();
	}

	@PutMapping("/contact")
	private Contact update(@RequestBody Contact contact) {
		contactService.saveOrUpdate(contact);
		return contact;
	}
}