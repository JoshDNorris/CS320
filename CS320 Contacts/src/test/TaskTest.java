//Author Name: Joshua Norris
//Date: 27 Mar 2021
//Course ID: CS320
//Description: Tests the test class

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tasks.Task;


//Tests Contact class
class TaskTest {

	//Testing that creating a new task assigns the correct attributes
	@Test
	void testContactClass() {
		Task task = new Task("testID", "testName", "testDescription");
		assertTrue(task.getTaskID().equals("testID"));
		assertTrue(task.getTaskName().equals("testName"));
		assertTrue(task.getDescription().equals("testDescription"));
	}
	
	//The following tests if an error is given when each attribute exceeds required parameters
	@Test
	void testIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testIDisTooLong", "testName", "testDescription");
		});
	}
	
	void testIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "testName", "testDescription");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", "test Name Is Too Long to fit in the parameters of this requirement", "testDescription");
		});
	}
	
	@Test
	void testFirstIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", null, "testDescription");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", "testName", "testDescription is too long to fit in the parameters of this requirement");
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("testID", "testName", null);
		});
	}

}