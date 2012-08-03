package org.exadel.task.board;

import org.exadel.task.board.dao.GenericDaoHibernate;
import org.exadel.task.board.model.Card;
import org.exadel.task.board.model.CardList;
import org.exadel.task.board.model.User;

public class Test {
	public static void main(String[] args) {

		GenericDaoHibernate<User> userDao = new GenericDaoHibernate<User>(
				User.class);

		GenericDaoHibernate<CardList> listDao = new GenericDaoHibernate<CardList>(
				CardList.class);

		GenericDaoHibernate<Card> cardDao = new GenericDaoHibernate<Card>(
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
		
		
		userDao.getSession().beginTransaction();
		userDao.create(user);
		
		listDao.create(list);
		
		cardDao.create(card1);	
		
		
		userDao.getSession().getTransaction().commit();
		
		
		
	}

}