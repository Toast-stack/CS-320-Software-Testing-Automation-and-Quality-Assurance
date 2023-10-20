package Appointments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

	final private List<Appointment> appointmentList = new ArrayList<>();
	
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment appt = new Appointment(newUniqueID());
		appointmentList.add(appt);
	}
	
	public void newAppointment(Date date) {
		Appointment appt = new Appointment(newUniqueID(), date);
		appointmentList.add(appt);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment appt = new Appointment(newUniqueID(), date, description);
		appointmentList.add(appt);
	}
	
	public void deleteAppointment(String ID) throws Exception{
		appointmentList.remove(searchForAppointment(ID));
	}
	
	protected List<Appointment> getAppointmentList() { return appointmentList;}
	
	private Appointment searchForAppointment(String ID) throws Exception{
		int index = 0;
		while (index< appointmentList.size()) {
			if(ID.equals(appointmentList.get(index).getAppointmentID())) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("The appointment doesn't exist");
	}
}
