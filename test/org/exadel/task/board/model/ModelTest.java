package org.exadel.task.board.model;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.dao.GenericDao;
import org.exadel.task.board.dao.GenericDaoHibernate;
import org.junit.Test;

public class ModelTest {

	@Test
	public void firstTest() {
		GenericDao<User> userDao = new GenericDaoHibernate<User>(User.class);

		GenericDao<CardList> listDao = new GenericDaoHibernate<CardList>(
				CardList.class);

		userDao.getSession().beginTransaction();

		final User user = new User();
		user.setName("Alex");

		final Card card1 = new Card();
		card1.setTitle("First Card");
		card1.setType("Task");
		card1.setContent("asdf");
		card1.setUser(user);

		final Card card2 = new Card();
		card2.setTitle("Second Card");
		card2.setType("Task");
		card2.setContent("qwer");
		card2.setUser(user);

		CardList list = new CardList();
		list.setTitle("First List");
		list.setUser(user);
		list.addCard(card1);
		list.addCard(card2);

		userDao.create(user);
		listDao.create(list);
		
		userDao.getSession().getTransaction().commit();

		userDao.getSession().beginTransaction();

		list = listDao.read(list.getId());
		List<Card> cards = list.getCards();

		
		System.out.println(card1);
		System.out.println(card2);

		for (Card card : cards) {
			System.out.println(card);
		}

		userDao.getSession().close();

		userDao.getSession().beginTransaction();

		listDao.delete(list);
		userDao.delete(user);

		userDao.getSession().getTransaction().commit();
	}

}
