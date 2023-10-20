package TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	private String ID, Name, Description, LongID, LongName, LongDescription;
	
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		Name = "Bill William Billiam";
		Description = "This should be filled in!";
		LongID = "11223344556677889900";
		LongName = "Smitty Werbenjägermanjensen";
		LongDescription = "The task will require a string that will not be longer than 50 characters."
				+ " In addition to this it should not be left blank.";
	}
	
	@Test
	void getTaskIDTest() {
		Task task = new Task(ID);
		Assertions.assertEquals(ID,task.getTaskID());
	}
	
	@Test
	void getNameTest() {
		Task task = new Task(ID, Name);
		Assertions.assertEquals(Name, task.getName());
	}
	
	@Test
	void getDescriptionTest() {
		Task task = new Task(ID, Name, Description);
		Assertions.assertEquals(Description, task.getDescription());
	}
	
	@Test
	void setNameTest() {
		Task task = new Task();
		task.setName(Name);
		Assertions.assertEquals(Name, task.getName());
	}
	
	@Test
	void setDescription() {
		Task task = new Task();
		task.setDescription(Description);
		Assertions.assertEquals(Description, task.getDescription());
	}
	
	@Test
	void TaskIDLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(LongID));
	}
	
	@Test
	void setLongNameTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->  task.setName(LongName));
	}
	
	@Test
	void setLongDescriptionTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->  task.setDescription(LongDescription));
	}
	
	@Test
	void taskIDNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new Task(null));
	}
	
	@Test
	void taskNameNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->  task.setName(null));
	}
	
	@Test
	void taskDescruptionNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () ->  task.setDescription(null));
	}
}
