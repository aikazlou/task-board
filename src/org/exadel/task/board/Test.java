package org.exadel.task.board;

import org.exadel.task.board.dao.GenericDaoHibernate;
import org.exadel.task.board.model.Card;
import org.exadel.task.board.model.CardList;
import org.exadel.task.board.model.User;

public class Test {
	public static void main(String[] args) {

		GenericDaoHibernate<User, Integer> userDao = new GenericDaoHibernate<User, Integer>(
				User.class);

		GenericDaoHibernate<CardList, Integer> listDao = new GenericDaoHibernate<CardList, Integer>(
				CardList.class);

		GenericDaoHibernate<Card, Integer> cardDao = new GenericDaoHibernate<Card, Integer>(
				Card.class);

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
				

		final CardList list = new CardList();
		list.setTitle("First List");
		list.setUser(user);
		list.addCard(card1);
		
		userDao.create(user);
		cardDao.create(card1);
		listDao.create(list);
		
		
	}

}