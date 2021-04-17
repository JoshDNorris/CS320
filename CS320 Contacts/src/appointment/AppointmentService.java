//Author Name: Joshua Norris
//Date: 1 Apr 2021
//Course ID: CS320
//Description: Appointment service class. Adds appointments with unique IDs and can delete appointments by ID

package appointment;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppointmentService {
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	LocalDate newDate = LocalDate.of(2026, 9, 26);
	String newDescription = "";
	
	// Displays appointment list
	public void displayAppointmentList() {
		for (int i = 0; i < appointmentList.size(); i++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(i).getAppointmentID());
			System.out.println("\t Appointment Date: " + appointmentList.get(i).getAppointmentDate());
			System.out.println("\t Description: " + appointmentList.get(i).getAppointmentDescription());
		}
	}
	
	// Adds appointment, using date and description as parameters
	public void addAppointment(LocalDate appointmentDate, String appointmentDescription) {
		Appointment newAppointment = new Appointment(newDate, newDescription);
		appointmentList.add(newAppointment);
	}
	
	// Returns appointment using ID as parameter
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment(null, null);
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().contentEquals(appointmentID)) {
				appointment = appointmentList.get(i);
			}
		}
		return appointment;
	}
	
	// Delete appointments based on ID given as parameter
	public void deleteAppointment(String appointmentID) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID().contentEquals(appointmentID)) {
				appointmentList.remove(i);
				break;
			}
			if (i == appointmentList.size() - 1) {
				System.out.println("Appointment ID " + appointmentID + " not found.");
			}
		}
	}

}
