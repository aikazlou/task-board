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
		

		PK pk = (PK) session.save(o);

		

		return pk;
	}

	@Override
	public T read(PK id) {
		getSession();
		
		T res = (T) session.get(type, id);
		
		return res;

	}

	@Override
	public void update(T o) {
		getSession();
		
		session.update(o);
		
	}

	@Override
	public void delete(T o)
	{
		getSession();
	
		session.delete(o);
		
	}

	public void getSession()
	{

		session = SessionFactoryUtil.getSessionFactory().getCurrentSession();

	}

}
