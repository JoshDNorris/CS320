//Author Name: Joshua Norris
//Date: 27 Mar 2021
//Course ID: CS320
//Description: Task service class that adds tasks with unique ID, deletes task by ID, and updates the name and description of tasks

package tasks;

import java.util.*;

public class TaskService {
	String taskID;
	String taskName;
	String taskDescription;
	List<Task> taskList = new ArrayList<>();
	
	// Returns task list
	public List<Task> getTaskList() {
		return taskList;
	}
	
	// Adds task with same methodology as contact service. Uses task list size to create original ID
	public void addTask() {
		if (taskList.isEmpty()) {
			taskID = "1";
		}
		else {
			taskID = Integer.toString(taskList.size() + 1);
		}
		
		for (int i = 0; i < taskList.size(); i ++) {
		if (taskList.get(i).taskID.equals(taskID) || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		}
		Task task = new Task(taskID, "taskName", "taskDescription");
		taskList.add(task);
	}
	
	
	// Removes task by ID from task list
	public void deleteTask(String taskID) {
		for (int i = 0; i < taskList.size(); i ++) {
			if (taskList.get(i).taskID.equals(taskID)) {
				taskList.remove(i);
			}
		}
	}
	
	// Updates name of certain task by ID
	public void updateName(String taskID, String newName) {
		if(newName == null || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		for (int i = 0; i < taskList.size(); i ++) {
			if (taskList.get(i).taskID.equals(taskID)) {
				taskList.get(i).taskName = newName;
			}
		}
	}
	
	// Updates description of task by task ID
	public void updateDescription(String taskID, String newDescription) {
		if(newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		for (int i = 0; i < taskList.size(); i ++) {
			if (taskList.get(i).taskID.equals(taskID)) {
				taskList.get(i).taskDescription = newDescription;
			}
		}
	}
	
}
