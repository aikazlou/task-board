package org.exadel.task.board.dao;

import org.hibernate.Session;

public interface GenericDao<T> {

	int create(T newInstance);

	T read(int id);

	void update(T transientObject);

	void delete(T persistentObject);

	public Session getSession();
}