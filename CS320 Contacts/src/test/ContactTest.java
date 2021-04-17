//Author Name: Joshua Norris
//Date: 18 Mar 2021
//Course ID: CS320
//Description: Tests the contact class

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contacts.Contact;


//Tests Contact class
class ContactTest {

	//Testing that creating a new contact assigns the correct names
	@Test
	void testContactClass() {
		Contact contact = new Contact("testID", "testFirst", "testLast", "testPhone1", "testAddress");
		assertTrue(contact.getFirstName().equals("testFirst"));
		assertTrue(contact.getContactID().equals("testID"));
		assertTrue(contact.getLastName().equals("testLast"));
		assertTrue(contact.getPhone().equals("testPhone1"));
		assertTrue(contact.getAddress().equals("testAddress"));
	}
	
	//The following tests if an error is given when each attribute exceeds required parameters
	@Test
	void testIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testIDisTooLong", "testFirst", "testLast", "testPhone1", "testAddress");
		});
	}
	
	void testIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "testFirst", "testLast", "testPhone1", "testAddress");
		});
	}
	
	@Test
	void testFirstTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirstIsTooLong", "testLast", "testPhone1", "testAddress");
		});
	}
	
	@Test
	void testFirstIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", null, "testLast", "testPhone1", "testAddress");
		});
	}
	
	@Test
	void testLastTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLastisTooLong", "testPhone1", "testAddress");
		});
	}
	
	@Test
	void testLastIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", null, "testPhone1", "testAddress");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLast", "testPhoneisTooLong", "testAddress");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLast", "testPhone", "testAddress");
		});
	}
	
	@Test
	void testPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLast", null, "testAddress");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLast", "testPhone1", "testAddressisTooLong. Way too long. Like, what did you do to get it here");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testID", "testFirst", "testLast", "testPhone1", null);
		});
	}

}
