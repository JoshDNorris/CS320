//Author Name: Joshua Norris
//Date: 1 Apr 2021
//Course ID: CS320
//Description: Appointment class. Includes appointment ID, date, and description


package appointment;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
	private final String appointmentID;
	private LocalDate appointmentDate;
	private String appointmentDescription;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// Constructor
	public Appointment(LocalDate newDate, String appointmentDescription) {
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		if (newDate == null || newDate.isBefore(LocalDate.now())) {
			this.appointmentDate = LocalDate.now();
		}
		else {
			this.appointmentDate = newDate;
		}
		if (appointmentDescription == null || appointmentDescription.isBlank()) {
			this.appointmentDescription = "NULL";
		}
		else if (appointmentDescription.length() > 50) {
			this.appointmentDescription = appointmentDescription.substring(0, 10);
		}
		else {
			this.appointmentDescription = appointmentDescription;
		}
	}
	
	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	//Setters
	public void setAppointmentDate(LocalDate appointmentDate) {
		if (appointmentDate == null || appointmentDate.isBefore(LocalDate.now())) {
			this.appointmentDate = LocalDate.now();
		}
		else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.isBlank()) {
			this.appointmentDescription = "NULL";
		}
		else if (appointmentDescription.length() > 50) {
			this.appointmentDescription = appointmentDescription.substring(0, 10);
		}
		else {
			this.appointmentDescription = appointmentDescription;
		}
	}
	

}
