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

		final User user = new User("MyLogin", "Alex");

		final Card card1 = new Card(user, "FirstCard", "Task", "asdf");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		final Card card2 = new Card(user, "Second Card", "Task", "qwer");

		CardList list = new CardList(user, "First List");
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