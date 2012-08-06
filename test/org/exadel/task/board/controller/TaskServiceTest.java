package org.exadel.task.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.model.Card;
import org.exadel.task.board.model.CardList;
import org.exadel.task.board.model.Comment;
import org.exadel.task.board.model.User;

import org.junit.Test;

public class TaskServiceTest {

	private final TaskService taskService = new TaskService();

	@Test
	public void createUserTest() {

		final User user = taskService.createUser("FirstLogin", "Ivanov");

		final User user1 = taskService.getUser(user.getId());

		taskService.deleteUser(user1);
		assertEquals("FirstLogin", user1.getLogin());
		assertEquals("Ivanov", user1.getName());

	}

	@Test
	public void createListTest() {

		final User user = taskService.createUser("SecondLogin", "Ivanov");
		final Card card = new Card(user, "First", "Task", "abc");

		CardList list = new CardList(user, "First");
		list.addCard(card);

		taskService.createList(list);

		list = taskService.getList(list.getId());

		taskService.deleteList(list);
		taskService.deleteUser(user);

		List<Card> cards = list.getCards();
		assertEquals(cards.get(0).toString(), card.toString());

		List<Comment> comments = cards.get(0).getComments();
		assertEquals(comments.size(), 0);
	}

	@Test
	public void moveCardTest() {

		final User user = taskService.createUser("ThirdLogin", "Ivanov");
		final Card card = new Card(user, "First", "Task", "abc");

		CardList list1 = new CardList(user, "First");
		list1.addCard(card);

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CardList list2 = new CardList(user, "Second");
		if (list1.equals(list2)) {
			System.out.println("list1 equals list2");
		}

		taskService.createList(list1);
		taskService.createList(list2);

		taskService.moveCard(card, list1, list2);

		list1 = taskService.getList(list1.getId());
		list2 = taskService.getList(list2.getId());

		taskService.deleteList(list1);
		taskService.deleteList(list2);
		taskService.deleteUser(user);

		assertFalse(list1.contains(card));
		assertTrue(list2.contains(card));

		// assertEquals(list1.getCards().size(), 0);
		// assertEquals(list2.getCards().size(), 1);
	}

}
