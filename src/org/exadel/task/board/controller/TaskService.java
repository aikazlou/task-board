package org.exadel.task.board.controller;

import org.exadel.task.board.dao.*;
import org.exadel.task.board.model.*;

public class TaskService {

	private GenericDao<User> userDao = new GenericDaoHibernate<User>(User.class);
	private GenericDao<CardList> listDao = new GenericDaoHibernate<CardList>(
			CardList.class);
	private GenericDao<Card> cardDao = new GenericDaoHibernate<Card>(Card.class);
	private GenericDao<Comment> commentDao = new GenericDaoHibernate<Comment>(
			Comment.class);

	public TaskService() {
	}

	public int createUser(User user) {
		beginTransaction();

		int id = userDao.create(user);

		commit();
		return id;
	}

	public User getUser(Integer id) {
		beginTransaction();

		final User user = userDao.read(id);

		closeSession();
		return user;
	}

	public int createList(CardList list) {
		beginTransaction();

		int id = listDao.create(list);

		commit();
		return id;
	}

	public CardList getList(Integer id) {
		beginTransaction();

		CardList list = listDao.read(id);

		closeSession();
		return list;
	}

	public int createCard(Card card) {
		beginTransaction();

		int id = cardDao.create(card);

		commit();
		return id;
	}

	public Card getCard(Integer id) {
		beginTransaction();

		Card card = cardDao.read(id);

		closeSession();
		return card;
	}

	public int createComment(Comment comment) {
		beginTransaction();

		int id = commentDao.create(comment);

		commit();
		return id;
	}

	public Comment getComment(Integer id) {
		beginTransaction();

		Comment comment = commentDao.read(id);

		closeSession();
		return comment;
	}

	public boolean moveCard(Card card, CardList fromList, CardList toList) {

		if (!fromList.contains(card)) {
			return false;
		}
		if (toList.contains(card)) {
			return true;
		}

		beginTransaction();

		fromList.removeCard(card);
		toList.addCard(card);

		commit();

		return true;

	}

	public void deleteUser(User user) {
		beginTransaction();
		userDao.delete(user);
		commit();
	}

	public void deleteList(CardList list) {
		beginTransaction();
		listDao.delete(list);
		commit();
	}

	public void deleteCard(Card card) {
		beginTransaction();
		cardDao.delete(card);
		commit();
	}

	public void deleteComment(Comment comment) {
		beginTransaction();
		commentDao.delete(comment);
		commit();
	}

	private void beginTransaction() {
		userDao.getSession().beginTransaction();
	}

	private void commit() {

		userDao.getSession().getTransaction().commit();
	}

	private void rollback() {
		userDao.getSession().getTransaction().rollback();
	}

	private void closeSession() {
		userDao.getSession().close();
	}

}
