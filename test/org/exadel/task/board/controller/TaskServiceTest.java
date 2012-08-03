package org.exadel.task.board.controller;

import static org.junit.Assert.*;

import org.exadel.task.board.model.User;
import org.junit.Test;

public class TaskServiceTest {
	
	private TaskService taskService=new TaskService();

	@Test
	public void createUserTest() {
		User user = new User();
		user.setName("Irina");
		int id = taskService.createUser(user);
		
		User user1 = taskService.getUser(id);
		assertEquals (user.toString(),user1.toString());		
		
	}

}
