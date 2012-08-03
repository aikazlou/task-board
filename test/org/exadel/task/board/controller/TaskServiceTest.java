package org.exadel.task.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.model.Card;
import org.exadel.task.board.model.CardList;
import org.exadel.task.board.model.Comment;
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
	
	@Test
	public void createListTest() {
		
		User user = new User();
		user.setName("Ason");
		taskService.createUser(user);
		
		
		CardList list = new CardList();
		list.setTitle("My list");
		list.setUser(user);
		
		Card card = new Card();
		card.setContent("Lalala");
		card.setTitle("My Card");
		card.setType("fgh");
		card.setUser(user);
		
		list.addCard(card);
		
		int id1 = taskService.createList(list);
		CardList list1 = taskService.getList(id1);
		
		List <Comment> listComment = list1.getCards().get(0).getComments();
		
		assertEquals(list1.getCards().get(0).toString(),card.toString());
		
		
		
	}

}
