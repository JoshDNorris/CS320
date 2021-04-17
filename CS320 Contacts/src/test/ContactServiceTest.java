//Author Name: Joshua Norris
//Date: 18 Mar 2021
//Course ID: CS320
//Description: Tests the contact service class

package test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;

import contacts.ContactService;

class ContactServiceTest {

	//Testing adding a new contact to contact list and that new contact is given the assigned values
	@Test
	void testAddNewContact() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		int initialContactListSize = contactList.size();
		
		myService.AddNewContact(contactList);
		assertTrue(initialContactListSize < contactList.size());
		assertTrue(contactList.get(contactList.size() - 1).getFirstName().equals("testFirst"));
		assertTrue(contactList.get(contactList.size() - 1).getLastName().equals("testLast"));
		assertTrue(contactList.get(contactList.size() - 1).getPhone().equals("testPhone1"));
		assertTrue(contactList.get(contactList.size() - 1).getAddress().equals("testAddress"));
	}
	
	//Tests for successful deletion of contact
	@Test
	void testDeleteContact() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		
		myService.AddNewContact(contactList);
		int initialContactListSize = contactList.size();
		
		String IDToDelete = contactList.get(0).getContactID();
		myService.DeleteContact(contactList, IDToDelete);
		assertTrue(initialContactListSize > contactList.size());
	}
	//The following tests ensure that the update methods work as intended
	@Test
	void testUpdateContactFirst() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		myService.UpdateFirst(contactList, contactID, "New Name");
		assertTrue(contactList.get(0).getFirstName().equals("New Name"));
	}
	
	@Test
	void testUpdateContactLast() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		myService.UpdateLast(contactList, contactID, "New Name");
		assertTrue(contactList.get(0).getLastName().equals("New Name"));
	}
	
	@Test
	void testUpdateContactPhone() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		myService.UpdatePhone(contactList, contactID, "NewPhone12");
		assertTrue(contactList.get(0).getPhone().equals("NewPhone12"));
	}
	
	@Test
	void testUpdateContactAddress() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		myService.UpdateAddress(contactList, contactID, "New Address");
		assertTrue(contactList.get(0).getAddress().equals("New Address"));
	}
	
	//Testing for duplicate ID. Possible when deleting a contact due to assignment method of IDs
	@Test
	void testDuplicateID() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		myService.AddNewContact(contactList);
		myService.AddNewContact(contactList);
		String IDToDelete = contactList.get(1).getContactID();
		myService.DeleteContact(contactList, IDToDelete);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.AddNewContact(contactList);
		});
		
	}
	
	@Test
	void testUpdateContactFirstIsTooLong() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.UpdateFirst(contactList, contactID, "New Name Is Too Darn Long");
		});
	}
	
	//Testing to ensure any updated parameter still meets size original requirements
	@Test
	void testUpdateContactLastIsTooLong() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.UpdateLast(contactList, contactID, "New Name Is Too Darn Long");
		});
	}
	
	@Test
	void testUpdateContactPhoneIsTooLong() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.UpdatePhone(contactList, contactID, "New Phone Is Too Darn Long");
		});
	}
	
	@Test
	void testUpdateContactPhoneIsTooShort() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.UpdatePhone(contactList, contactID, "TooShort");
		});
	}
	
	@Test
	void testUpdateContactAddressIsTooLong() {
		ContactService myService = new ContactService();
		List<Contact> contactList = new ArrayList<>();
		myService.AddNewContact(contactList);
		String contactID = contactList.get(0).getContactID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myService.UpdateAddress(contactList, contactID, "The longest address to have ever graced the address books. The phone book can't even contain it.");
		});
	}
}
