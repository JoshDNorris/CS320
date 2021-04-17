//Author Name: Joshua Norris
//Date: 18 Mar 2021
//Course ID: CS320
//Description: Contact class. Creates contact object with ID, first and last name, phone number, and address

package contacts;

// Contact class
public class Contact {
	String contactID;
	String firstName;
	String lastName;
	String phone;
	String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	
}
