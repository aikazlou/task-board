package org.exadel.task.board.dao;

import org.hibernate.Session;

public class GenericDaoHibernate<T> implements GenericDao<T> {

	private Class<T> type;

	public GenericDaoHibernate(Class<T> type) {
		this.type = type;
	}

	@Override
	public int create(T o) {

		final Session session = getSession();

		int pk = (Integer) session.save(o);

		return pk;
	}

	@Override
	public T read(int id) {

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
