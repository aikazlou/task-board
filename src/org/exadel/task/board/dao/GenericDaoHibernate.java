package org.exadel.task.board.dao;

import java.io.Serializable;

import org.hibernate.Session;

import org.exadel.task.board.*;

public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK>
{

	private Session session;

	private Class<T> type;

	public GenericDaoHibernate(Class<T> type)
	{
		this.type = type;

	}

	@Override
	public PK create(T o) {
		getSession();
		session.beginTransaction();

		PK pk = (PK) session.save(o);

		session.getTransaction().commit();

		return pk;
	}

	@Override
	public T read(PK id) {
		getSession();
		session.beginTransaction();
		T res = (T) session.get(type, id);
		session.getTransaction().commit();
		return res;

	}

	@Override
	public void update(T o) {
		getSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T o)
	{
		getSession();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
	}

	public void getSession()
	{

		session = SessionFactoryUtil.getSessionFactory().getCurrentSession();

	}

}
