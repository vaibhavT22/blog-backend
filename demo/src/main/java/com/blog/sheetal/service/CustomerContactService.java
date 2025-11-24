package com.blog.sheetal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blog.sheetal.model.CustomerContact;
import com.blog.sheetal.repository.CustomerContactRepository;

@Service
public class CustomerContactService {
	@Autowired
	CustomerContactRepository customerContactRepository;
	
	public CustomerContact addCustomerContact(CustomerContact customerContact) {
		CustomerContact  savedContact = new CustomerContact();
		 savedContact.setName(customerContact.getName());
		 savedContact.setEmail(customerContact.getEmail());
		 savedContact.setMessage(customerContact.getMessage());
		return customerContactRepository.save( savedContact);
		
	}
	public List<CustomerContact> getAllCustomerContacts() {
		return customerContactRepository.findAll();
	}
	public void deleteCustomerContact(Long id) {
		customerContactRepository.deleteById(id);
	}
	public CustomerContact getCustomerContactByEmail(String email) {
		return customerContactRepository.findAll().stream()
				.filter(contact -> contact.getEmail().equalsIgnoreCase(email))
				.findFirst()
				.orElse(null);
	}
	public Long deleteAllCustomerContacts() {
		Long count = customerContactRepository.count();
		customerContactRepository.deleteAll();
		return count;
	}
	public List<CustomerContact> displayMessageByEmail(String email) {
		return customerContactRepository.findAll().stream()
				.filter(contact -> contact.getEmail().equalsIgnoreCase(email))
				.toList();
	}
	public void deleteContactByEmail(String email) {
		List<CustomerContact> contactsToDelete = displayMessageByEmail(email);
		customerContactRepository.deleteAll(contactsToDelete);
	}
	public String blockEmail(String email) {
		// This is a placeholder implementation. In a real application, you would
		// maintain a separate list or database table for blocked emails.
		// Here, we simply delete all contacts from the specified email.
		deleteContactByEmail(email);
		return "Email " + email + " has been blocked and all associated contacts have been deleted.";
	}
}
