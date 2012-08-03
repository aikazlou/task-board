package org.exadel.task.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.model.Card;
import org.exadel.task.board.model.CardList;
import org.exadel.task.board.model.Comment;
import org.exadel.task.board.model.User;

import org.junit.Test;

public class TaskServiceTest {

	private TaskService taskService = new TaskService();

	@Test
	
	public void createUserTest() {
		final User user = new User();
		user.setName("Irina");
		int id = taskService.createUser(user);

		final User user1 = taskService.getUser(id);
		assertEquals(user.toString(), user1.toString());

	}

	@Test
	public void createListTest1() {
		final User user = new User();
		user.setName("Alexander");

		final Card card = new Card();
		card.setTitle("First");
		card.setType("Task");
		card.setContent("abc");
		card.setUser(user);

		CardList list = new CardList();
		list.setTitle("First");
		list.setUser(user);
		list.addCard(card);

		taskService.createUser(user);
		taskService.createList(list);

		list = taskService.getList(list.getId());
		List<Card> cards = list.getCards();
		assertEquals(cards.get(0).toString(), card.toString());

		List<Comment> comments = cards.get(0).getComments();
		assertEquals(comments.size(), 0);

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
