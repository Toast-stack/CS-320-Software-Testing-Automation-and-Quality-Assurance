package TaskService;

public class Task {

	private String taskID, Name, Description;
	
	Task(){
		taskID = "Initial";
		Name = "Initial";
		Description = "Initital Description";
		
	}
	
	Task(String taskID){
		getTaskID(taskID);
		Name = "Initial";
		Description = "Initital Description";
	}
	
	Task(String taskID,String Name){
		getTaskID(taskID);
		setName(Name);
		Description = "Initital Description";
		
	}
	
	Task(String taskID, String Name, String Description){
		getTaskID(taskID);
		setName(Name);
		setDescription(Description);
		

	}
	
	public final String getTaskID () {return taskID;}
	public final String getName() {return Name;}
	
	protected void setName(String Name) {
		
		if(Name == null || Name.length() > 20) {
			throw new IllegalArgumentException(
					"The task name is invalid. Please make sure the name is less than 20 characters "
					+ "and is not empty.");
			
		}
		else {
			this.Name = Name;
		}
	}
	public final String getDescription() {return Description;}
	protected void setDescription(String Description) {
		if(Description == null || Description.length() > 50) {
			throw new IllegalArgumentException(
					"The task description is invalid. Please make sure the description is less than 50 characters "
					+ "and is not empty.");
			
		}
		else {
			this.Description = Description;
		}
		
	}
	
	private void getTaskID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException(
					"An error was found: The task ID was null or was made longer than 10 characters. ");
			
		}
		else {
			this.taskID = taskID;
		}
		
	}
	
}
