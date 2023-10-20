package TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class TaskServiceTest {
	
	private String ID, Name, Description, LongName, LongDescription;
	
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		Name = "Bill William Billiam";
		Description = "This should be filled in!";
		LongName = "Smitty Werbenjägermanjensen";
		LongDescription = "The task will require a string that will not be longer than 50 characters."
				+ " In addition to this it should not be left blank.";
	}
	
	@Test
	void newTaskTest() {
		TaskService service = new TaskService();
		service.newTask();
		Assertions.assertNotNull(service.getTaskList().get(0).getTaskID());
		Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getTaskID());
	}
	
	@Test
	void newTaskNameTest() {
		TaskService service = new TaskService();
		service.newTask(Name);
		Assertions.assertNotNull(service.getTaskList().get(0).getName());
		Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getName());
	}
	
	@Test
	void newTaskDescriptionTest() {
		TaskService service = new TaskService();
		service.newTask(Name, Description);
		Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
		Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getDescription());
	}
	
	@Test
	void newTaskLongNameTest() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(LongName));
	}
	
	@Test
	void newTaskLongDescriptionTest() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(Name, LongDescription));
	}
	
	@Test
	void newTaskNameNullTest() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
	}
	
	@Test
	void newTaskDescriptionNullTest() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(Name, null));
	}
	
	@Test
	void deleteTaskTest() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		assertEquals(1,service.getTaskList().size());
		service.deleteTask(service.getTaskList().get(0).getTaskID());
		assertEquals(0,service.getTaskList().size());
	}
	
	@Test
	void deleteTaskNotFoundTest() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		assertEquals(1, service.getTaskList().size());
		assertThrows(Exception.class, () -> service.deleteTask(ID));
		assertEquals(1,service.getTaskList().size());
	}
	
	@Test
	void updateNameTest() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		service.updateName(service.getTaskList().get(0).getTaskID(), Name);
		assertEquals(Name,service.getTaskList().get(0).getName());
	}
	
	@Test
	void updateDescriptionTest() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		service.updateDescription(service.getTaskList().get(0).getTaskID(), Description);
		assertEquals(Description, service.getTaskList().get(0).getDescription());
	}
	
	@Test
	void updateNameNotFoundTest() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		assertThrows(Exception.class,() -> service.updateName(ID, Name));
	}
	
	@Test
	void updateDescriptionNotFound() throws Exception{
		TaskService service = new TaskService();
		service.newTask();
		assertThrows(Exception.class, () -> service.updateDescription(ID, Description));
	}
	
	@RepeatedTest (4)
	void UuidTest() {
		TaskService service = new TaskService();
		service.newTask();
		service.newTask();
		service.newTask();
		assertEquals(3,service.getTaskList().size());
		assertNotEquals(service.getTaskList().get(0).getTaskID(),
				service.getTaskList().get(1).getTaskID());
				assertNotEquals(service.getTaskList().get(0).getTaskID(),
				service.getTaskList().get(2).getTaskID());
				assertNotEquals(service.getTaskList().get(1).getTaskID(),
				service.getTaskList().get(2).getTaskID());
	}
}

