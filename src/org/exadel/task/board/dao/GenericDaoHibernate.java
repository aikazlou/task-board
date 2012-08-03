package org.exadel.task.board.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK>
{

	private Class<T> type;

	public GenericDaoHibernate(Class<T> type)
	{
		this.type = type;

	}

	@Override
	public PK create(T o) {

		final Session session = getSession();

		@SuppressWarnings("unchecked")
		PK pk = (PK) session.save(o);

		return pk;
	}

	@Override
	public T read(PK id) {
		final Session session = getSession();

		@SuppressWarnings("unchecked")
		T res = (T) session.byId(type).load(id);

		return res;

	}

	@Override
	public void update(T o) {
		final Session session = getSession();
		session.update(o);
	}

	@Override
	public void delete(T o) {

		final Session session = getSession();
		session.delete(o);

	}

	@Override
	public Session getSession() {

		return SessionFactoryUtil.getSessionFactory().getCurrentSession();

	}

}
