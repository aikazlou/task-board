package org.exadel.task.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NaturalId
	@Column(name = "LOGIN")
	private String login;

	@NaturalId
	@Column(name = "TIME_STAMP")
	private long timestamp;

	@Column(name = "NAME")
	private String name;

	User() {
		// default constructor for ORM
	}

	public User(String login) {
		this.login = login;
		timestamp = System.currentTimeMillis();
	}

	public User(String login, String name) {
		this.login = login;
		this.name = name;
		timestamp = System.currentTimeMillis();
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}

}
