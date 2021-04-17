//Author Name: Joshua Norris
//Date: 1 Apr 2021
//Course ID: CS320
//Description: Appointment test class. Tests appointment class

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import appointment.Appointment;

import org.junit.jupiter.api.DisplayName;

class AppointmentTest {

	// Testing that appointment attributes are created correctly, without exceeding given constraints
	@Test
	@DisplayName("Appointment ID cannot have more than 10 characters")
	void testAppointmentIDWithMoreThanTenCharacters() {
		LocalDate newDate = LocalDate.of(2026, 9, 26);
		Appointment appointment = new Appointment(newDate, "Appointment Description");
		if (appointment.getAppointmentID().length() > 10) {
			fail("Contact ID has more than 10 characters");
		}
	}
		
	@Test
	@DisplayName("Appointment description cannot have more than 50 characters")
	void testAppointmentDescriptionWithMoreThanFiftyCharacters() {
		LocalDate newDate = LocalDate.of(2026, 9, 26);
		Appointment appointment = new Appointment(newDate, "Appointment Description with more than fifty characters is just too much description");
		if (appointment.getAppointmentDescription().length() > 50) {
			fail("Contact description has more than 50 characters");
		}
	}
	
	@Test
	@DisplayName("Appointment date cannot be before current date")
	void testAppointmentDateIsInThePast() {
		LocalDate newDate = LocalDate.of(2006, 9, 26);
		Appointment appointment = new Appointment(newDate, "Appointment Description");
		if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
			fail("You cannot time travel");
		}
	}
	
	@Test
	@DisplayName("Appointment date cannot be null")
	void testAppointmentDateIsNull() {
		Appointment appointment = new Appointment(null, "Appointment Description");
		assertNotNull(appointment.getAppointmentDate(), "Date was null");
	}
	
	@Test
	@DisplayName("Appointment description cannot be null")
	void testAppointmentDescrioptionIsNull() {
		LocalDate newDate = LocalDate.of(2026, 9, 26);
		Appointment appointment = new Appointment(newDate, null);
		assertNotNull(appointment.getAppointmentDescription(), "Description was null");
	}

}
