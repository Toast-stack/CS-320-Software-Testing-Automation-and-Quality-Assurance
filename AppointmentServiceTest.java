package Appointments;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
	
	private String ID, description, LongDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		description = "The appointment will have a description";
		date = new Date(2022, Calendar.JANUARY, 1);
		LongDescription = "This description shouldn't be used for the sample description but works for testing.";
		pastDate = new Date(0);
	}
	
	@Test
	void testNewAppointment() {
		AppointmentService service = new AppointmentService();
		service.newAppointment();
		assertNotNull(service.getAppointmentList().get(0).getAppointmentID());
		assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(0).getDescription());
		
		service.newAppointment(date);
		assertNotNull(service.getAppointmentList().get(1).getAppointmentID());
		assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(1).getDescription());
		
		service.newAppointment(date, description);
		assertNotNull(service.getAppointmentList().get(2).getAppointmentID());
		assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(description, service.getAppointmentList().get(2).getDescription());
		
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
				service.getAppointmentList().get(1).getAppointmentID());
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
				service.getAppointmentList().get(2).getAppointmentID());
		assertNotEquals(service.getAppointmentList().get(1).getAppointmentID(),
				service.getAppointmentList().get(2).getAppointmentID());
		
		assertThrows(IllegalArgumentException.class, ()-> service.newAppointment(pastDate));
		assertThrows(IllegalArgumentException.class, ()-> service.newAppointment(date, LongDescription));
		
	}
	
	@Test
	void deleteAppointment() throws Exception{
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		service.newAppointment();
		service.newAppointment();
		
		String firstID = service.getAppointmentList().get(0).getAppointmentID();
		String secondID = service.getAppointmentList().get(1).getAppointmentID();
		String thirdID = service.getAppointmentList().get(2).getAppointmentID();
		
		assertNotEquals(firstID, secondID);
		assertNotEquals(firstID, thirdID);
		assertNotEquals(secondID, thirdID);
		assertNotEquals(ID, firstID);
		assertNotEquals(ID, secondID);
		assertNotEquals(ID, thirdID);
		
		assertThrows(Exception.class, ()->service.deleteAppointment(ID));
		
		service.deleteAppointment(firstID);
		assertThrows(Exception.class, ()-> service.deleteAppointment(firstID));
		assertNotEquals(firstID,service.getAppointmentList().get(0).getAppointmentID());
	}
}
