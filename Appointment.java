package Appointments;

import java.util.Date;

public class Appointment {

	final private byte AppointmentID_Length;
	final private byte AppointmentDescript_Length;
	final private String INITIALIZER;
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	{
		AppointmentID_Length = 10;
		AppointmentDescript_Length = 50;
		INITIALIZER = "INITIAL";
	}
	Appointment(){
		Date today = new Date();
		appointmentID = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	Appointment(String id){
		Date today = new Date();
		updateAppointmentID(id);
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	Appointment(String id, Date date){
		updateAppointmentID(id);
		updateDate(date);
		description = INITIALIZER;
	}
	
	Appointment(String id, Date date, String description){
		updateAppointmentID(id);
		updateDate(date);
		updateDescription(description);
	}
	
	public void updateAppointmentID (String id) {
		if (id == null) {
			throw new IllegalArgumentException("Appointment ID can't be null.");
		} 
		else if (id.length() > AppointmentID_Length) {
			throw new IllegalArgumentException("Appointment ID can't exceed " + AppointmentID_Length + " character.");
		}else {
			this.appointmentID = id;
		}
	}
	
	public String getAppointmentID() {return appointmentID;}
	
	public void updateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment date can't be null.");
		}
		else if (date.before(new Date())) {
			throw new IllegalArgumentException("An appointment can't be made in the past.");
		}
		else {
			this.appointmentDate = date;
		}
	}
	
	public Date getAppointmentDate() {return appointmentDate;}
	
	public void updateDescription(String description) {
		if(description == null) {
			throw new IllegalArgumentException("The appointment description can't be null.");
		}
		else if(description.length() > AppointmentDescript_Length) {
			throw new IllegalArgumentException("The appointment description can't exceed "+ AppointmentDescript_Length + "characters.");
		}
		else {
			this.description = description;
		}
	}
	public String getDescription() {return description;}
}
