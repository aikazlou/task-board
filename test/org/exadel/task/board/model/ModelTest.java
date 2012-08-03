package org.exadel.task.board.model;

import static org.junit.Assert.*;

import java.util.List;

import org.exadel.task.board.dao.GenericDao;
import org.exadel.task.board.dao.GenericDaoHibernate;
import org.junit.Test;

public class ModelTest {

	@Test
	public void firstTest() {
		GenericDao<User, Integer> userDao = new GenericDaoHibernate<User, Integer>(
				User.class);

		GenericDao<CardList, Integer> listDao = new GenericDaoHibernate<CardList, Integer>(
				CardList.class);

		GenericDao<Card, Integer> cardDao = new GenericDaoHibernate<Card, Integer>(
				Card.class);

		userDao.getSession().beginTransaction();

		final User user = new User();
		user.setName("Alex");

		final Card card1 = new Card();
		card1.setTitle("First Card");
		card1.setType("Task");
		card1.setContent("sfkjfls");
		card1.setUser(user);

		final Card card2 = new Card();
		card2.setTitle("Second Card");
		card2.setType("Task");
		card2.setContent("sfkjfls");
		card2.setUser(user);

		CardList list = new CardList();
		list.setTitle("First List");
		list.setUser(user);
		list.addCard(card1);
		list.addCard(card2);

		userDao.create(user);
		cardDao.create(card1);
		cardDao.create(card2);
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

		cardDao.delete(card1);
		cardDao.delete(card2);
		listDao.delete(list);
		userDao.delete(user);

		userDao.getSession().getTransaction().commit();
	}
}
