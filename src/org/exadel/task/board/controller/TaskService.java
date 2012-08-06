package org.exadel.task.board.controller;

import java.lang.Exception;
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

	public User getUser(int id) {
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

	public CardList getList(int id) {
		beginTransaction();

		CardList list = listDao.read(id);

		// CardList res = (CardList)listDao.getSession().merge(list);

		closeSession();
		return list;
	}

	public int createCard(Card card) {
		beginTransaction();

		int id = cardDao.create(card);

		commit();
		return id;
	}

	public Card getCard(int id) {
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

	public Comment getComment(int id) {
		beginTransaction();

		Comment comment = commentDao.read(id);

		closeSession();
		return comment;
	}

	public Card moveCard(Card card, CardList fromList, CardList toList) throws Exception {
		beginTransaction();

		final Card mergedCard = (Card) userDao.getSession().merge(card);
		final CardList mergedFromList = (CardList) userDao.getSession().merge(
				fromList);
		final CardList mergedToList = (CardList) userDao.getSession().merge(
				toList);

		if (!mergedFromList.contains(mergedCard)) {
			
			throw new Exception();

		}
		if (mergedToList.contains(mergedCard)) {
			
			return mergedCard;
		}

		mergedFromList.removeCard(mergedCard);
		mergedToList.addCard(mergedCard);

		commit();
<<<<<<< HEAD

		return mergedCard;
=======
		
		return true;
>>>>>>> branch 'dev' of https://github.com/aikazlou/task-board.git

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
