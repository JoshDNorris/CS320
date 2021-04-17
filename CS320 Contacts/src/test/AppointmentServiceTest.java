//Author Name: Joshua Norris
//Date: 1 Apr 2021
//Course ID: CS320
//Description: Appointment service test class. Testing adding and deleting appointments

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import appointment.Appointment;
import appointment.AppointmentService;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
class AppointmentServiceTest {
	
	// Tests adding appointment 
	@Test
	@DisplayName("Test to add appointment")
	@Order(1)
	void testAddAppointment() {
		LocalDate newDate = LocalDate.of(2026, 9, 26);
		AppointmentService service = new AppointmentService();
		service.addAppointment(newDate, "New Description");
		assertNotNull(service.getAppointment("0"));
	}
	
	// Tests deleting appointment
	@Test
	@DisplayName("Test to delete appointment")
	@Order(2)
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		LocalDate newDate = LocalDate.of(2026, 9, 26);
		service.addAppointment(newDate, "New Description");
		ArrayList<Appointment> appointmentCheckList = service.appointmentList;
		service.deleteAppointment(service.appointmentList.get(0).getAppointmentID());
		assertEquals(service.appointmentList, appointmentCheckList, "The appointment wasn't deleted");
	}

}
