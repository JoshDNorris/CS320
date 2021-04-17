//Author Name: Joshua Norris
//Date: 18 Mar 2021
//Course ID: CS320
//Description: Contact service class. Creates new contact, deletes contact, or updates contacts

package contacts;

import java.util.*;

// ContactService class. Allows editing of contacts stored in contact list
public class ContactService {
	List<Contact> contactList = new ArrayList<>();
	String contactID;
	String newFirstName;
	String newLastName;
	String newPhone;
	String newAddress;
		
	
	//Add new contact. Uses size of list to determine contact ID, but will throw an error if ID is already in use. 
	//Need to add ability to try another ID if one assigned is already in use.
	public List<Contact> AddNewContact(List<Contact> contactList) {
			if (contactList.isEmpty()) {
				contactID = "1";
			}
			else {
				contactID = Integer.toString(contactList.size() + 1);
			}
			
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID) || contactID.length() > 10) {
				throw new IllegalArgumentException("Invalid ID");
			}
		}
		Contact contact = new Contact(contactID, "testFirst", "testLast", "testPhone1", "testAddress");
		contactList.add(contact);
		return contactList;
	}
	
	//Deletes contact from list. 
	public List<Contact> DeleteContact(List<Contact> contactList, String contactID) {
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID)) {
				contactList.remove(i);
			}
		}
		return contactList;
	}
	
	//Updates first name of contact from a list of contacts
	public List<Contact> UpdateFirst(List<Contact> contactList, String contactID, String newFirstName) {
		if(newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID)) {
				contactList.get(i).firstName = newFirstName;
			}
		}
		return contactList;
	}
	
	//Updates last name
	public List<Contact> UpdateLast(List<Contact> contactList, String contactID, String newLastName) {
		if(newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID)) {
				contactList.get(i).lastName = newLastName;
			}
		}
		return contactList;
	}
	
	//Updates phone number
	public List<Contact> UpdatePhone(List<Contact> contactList, String contactID, String newPhone) {
		if(newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID)) {
				contactList.get(i).phone = newPhone;
			}
		}
		return contactList;
	}
	
	//Updates address
	public List<Contact> UpdateAddress(List<Contact> contactList, String contactID, String newAddress) {
		if(newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		for (int i = 0; i < contactList.size(); i ++) {
			if (contactList.get(i).contactID.equals(contactID)) {
				contactList.get(i).address = newAddress;
			}
		}
		return contactList;
	}
	
}
