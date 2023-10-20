package TaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	
	private final List<Task> taskList = new ArrayList<>();
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(0,Math.min(toString().length(),10));
	}
	private Task searchforTask(String id) throws Exception{
		int index = 0;
		while(index <taskList.size()) {
			if(id.equals(taskList.get(index).getTaskID())) {
				return taskList.get(index);
			}
			index++;
		}
		throw new Exception("The task you were looking for doesn't exist.");
	}
	
	public void newTask() {
		Task task = new Task(newUniqueID());
		taskList.add(task);
	}
	
	public void newTask(String Name) {
		Task task = new Task(newUniqueID(), Name);
		taskList.add(task);
	}
	
	public void newTask(String Name, String Description) {
		Task task = new Task(newUniqueID(), Name, Description);
		taskList.add(task);
	}
	
	public void deleteTask(String ID) throws Exception{
		taskList.remove(searchforTask(ID));
	}
	
	public void updateName(String ID, String Name) throws Exception{
		searchforTask(ID).setName(Name);
	}
	
	public void updateDescription(String ID, String Description) throws Exception{
		searchforTask(ID).setDescription(Description);
	}
	
	public List<Task> getTaskList() {return taskList;}
}
