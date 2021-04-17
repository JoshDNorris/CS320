//Author Name: Joshua Norris
//Date: 27 Mar 2021
//Course ID: CS320
//Description: Tests the test service class

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.TaskService;
import tasks.Task;

class TaskServiceTest {

	// Tests that a new task is created correctly, with the given attributes
	@Test
	void testAddNewTask() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		int initialTaskListSize = taskList.size();
		
		taskService.addTask();
		assertTrue(initialTaskListSize < taskList.size());
		assertTrue(taskList.get(taskList.size() - 1).getTaskName().equals("taskName"));
		assertTrue(taskList.get(taskList.size() - 1).getDescription().equals("taskDescription"));
	}
	
	// Verifying that a task is deleted when given a task ID
	@Test
	void testDeleteTask() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		
		taskService.addTask();
		int initialTaskListSize = taskList.size();
		
		String IDToDelete = taskList.get(0).getTaskID();
		taskService.deleteTask(IDToDelete);
		assertTrue(initialTaskListSize > taskList.size());
	}
	
	// Testing to ensure the task name update runs correctly
	@Test
	void testUpdateTaskName() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		
		taskService.addTask();
		String taskID = taskList.get(0).getTaskID();
		taskService.updateName(taskID, "newName");
		assertTrue(taskList.get(0).getTaskName().equals("newName"));
	}
	
	// Testing to ensure task description runs correctly
	@Test
	void testUpdateTaskDescription() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		
		taskService.addTask();
		String taskID = taskList.get(0).getTaskID();
		taskService.updateDescription(taskID, "new Description");
		assertTrue(taskList.get(0).getDescription().equals("new Description"));
	}
	
	// Testing to ensure a duplicate ID isn't given
	@Test
	void testDuplicateID() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		taskService.addTask();
		taskService.addTask();
		taskService.addTask();
		String IDToDelete = taskList.get(1).getTaskID();
		taskService.deleteTask(IDToDelete);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask();
		});
	}
	
	// The following tests ensure that either the name or description isn't too long
	@Test
	void testUpdateNameIsTooLong() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		taskService.addTask();
		String taskID = taskList.get(0).getTaskID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName(taskID, "New Name Is Too Darn Long");
		});
	}
	
	@Test
	void testUpdateDescriptionIsTooLong() {
		TaskService taskService = new TaskService();
		List<Task> taskList = taskService.getTaskList();
		taskService.addTask();
		String taskID = taskList.get(0).getTaskID();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateName(taskID, "testDescription is too long to fit in the parameters of this requirement");
		});
	}
		

}
