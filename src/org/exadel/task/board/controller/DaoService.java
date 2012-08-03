package org.exadel.task.board.controller;

import org.exadel.task.board.dao.*;
import org.exadel.task.board.model.*;

public class DaoService {

	private GenericDao<User> userDao = new GenericDaoHibernate<User>(User.class);
	private GenericDao<CardList> listDao = new GenericDaoHibernate<CardList>(
			CardList.class);
	private GenericDao<Card> cardDao = new GenericDaoHibernate<Card>(Card.class);
	private GenericDao<Comment> comment = new GenericDaoHibernate<Comment>(
			Comment.class);

	public DaoService() {
	}

	public void beginTransaction() {
		userDao.getSession().beginTransaction();
	}

	public void commit() {

		userDao.getSession().getTransaction().commit();
	}

	public void rollback() {
		userDao.getSession().getTransaction().rollback();
	}

	public void closeSession() {
		userDao.getSession().close();
	}

}
