package Appointments;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
	
	private String ID, description, LongID, LongDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		description = "The appointment will have a description";
		date = new Date(2022, Calendar.JANUARY, 1);
		LongID = "11223344556677889900";
		LongDescription = "This description shouldn't be used for the sample description but works for testing.";
		pastDate = new Date(0);
	}
	
	@Test
	void testUpdateAppointmentID() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, ()->appt.updateAppointmentID(null));
		assertThrows(IllegalArgumentException.class, ()->appt.updateAppointmentID(LongID));
		appt.updateAppointmentID(ID);
		assertEquals(ID,appt.getAppointmentID());
	}
	
	@Test
	void testGetAppointmentID() {
		Appointment appt = new Appointment(ID);
		assertNotNull(appt.getAppointmentID());
		assertEquals(appt.getAppointmentID().length(), 10);
		assertEquals(ID, appt.getAppointmentID());
	}
	
	@Test
	void testUpdateDate() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, ()->appt.updateDate(null));
		assertThrows(IllegalArgumentException.class, ()->appt.updateDate(pastDate));
		appt.updateDate(date);
		assertEquals(date, appt.getAppointmentDate());
	}
	
	@Test
	void testGetAppointmentDate() {
		Appointment appt = new Appointment(ID, date);
		assertNotNull(appt.getAppointmentDate());
		assertEquals(date, appt.getAppointmentDate());
	}
	
	@Test
	void testUpdateDescription() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class, ()-> appt.updateDescription(null));
		assertThrows(IllegalArgumentException.class, ()-> appt.updateDescription(LongDescription));
		appt.updateDescription(description);
		assertEquals(description, appt.getDescription());
	}
	
	@Test
	void testGetDescription() {
		Appointment appt = new Appointment(ID, date, description);
		assertNotNull(appt.getDescription());
		assertTrue(appt.getDescription().length()<= 50);
		assertEquals(description, appt.getDescription());
	}
}
