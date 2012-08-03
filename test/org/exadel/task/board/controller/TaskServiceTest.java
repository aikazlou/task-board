package org.exadel.task.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.model.*;
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
	public void createListTest() {
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

}
