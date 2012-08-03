package org.exadel.task.board.controller;

import org.exadel.task.board.dao.*;
import org.exadel.task.board.model.*;

public class ServiceDao {
	private GenericDao<User, Integer> userDao = new GenericDaoHibernate<User, Integer>(User.class);

	private GenericDao<CardList, Integer> listDao = new GenericDaoHibernate<CardList, Integer>(
			CardList.class);

	private GenericDao<Card, Integer> cardDao = new GenericDaoHibernate<Card, Integer>(Card.class);

	private GenericDao<Comment, Integer> commentDao = new GenericDaoHibernate<Comment, Integer>(
			Comment.class);

	public Integer createUser(User user) {
		 return userDao.create(user);
	}

	public User getUser(Integer id) {
		return userDao.read(id);

	}

	public Integer createList(CardList list) {
		return listDao.create(list);
	}

	public CardList getList(Integer id) {
		return listDao.read(id);
	}

	public Integer createCard(Card card) {
		return cardDao.create(card);
	}

	public Card getCard(Integer id) {
		return cardDao.read(id);
	}

	public Integer createComment(Comment comment) {
		return commentDao.create(comment);
	}

	public Comment getComment(Integer id) {
		return commentDao.read(id);
	}

	public boolean moveCard(Card card, CardList fromList,CardList toList) {
		
		if (!fromList.contains(card)) return false;
		if (toList.contains(card))  return true;	
		
		fromList.removeCard(card);
		toList.addCard(card);
		
		return true;

	}
	
	public void deleteUser (User user) {
		userDao.delete(user);
	}
	
	public void deleteList (CardList list) {
		listDao.delete(list);
	}
	
	public void deleteCard (Card card) {
		cardDao.delete(card);
	}
	
	public void deleteComment (Comment comment) {
		commentDao.delete(comment);
	}

}
