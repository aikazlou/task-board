package org.exadel.task.board.dao;

import java.io.Serializable;

import org.hibernate.Session;

public interface GenericDao<T, PK extends Serializable> {

	PK create(T newInstance);

	T read(PK id);

	void update(T transientObject);

	void delete(T persistentObject);

	Session getSession();
}
