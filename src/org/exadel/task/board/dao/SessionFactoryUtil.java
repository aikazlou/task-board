package org.exadel.task.board.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	public static SessionFactory buildSessionFactory() {
		try {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.exadel.task.board.model.User.class);
			cfg.addAnnotatedClass(org.exadel.task.board.model.Card.class);
			cfg.addAnnotatedClass(org.exadel.task.board.model.Comment.class);
			cfg.addAnnotatedClass(org.exadel.task.board.model.CardList.class);
			return cfg.configure().buildSessionFactory();

			// return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
