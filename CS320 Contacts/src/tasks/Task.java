//Author Name: Joshua Norris
//Date: 27 Mar 2021
//Course ID: CS320
//Description: Task class with ID, name, and description attributes

package tasks;

public class Task {
	String taskID;
	String taskName;
	String taskDescription;
	
	// Default task object, with ID, name, and description
	public Task(String taskID, String taskName, String taskDescription) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		
		
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		
	}
	
	public String getTaskID() {
		return taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getDescription() {
		return taskDescription;
	}
}
