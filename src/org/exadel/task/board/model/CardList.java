package org.exadel.task.board.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CardList")
public class CardList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	@ManyToOne
	@JoinColumn(name = "authorId")
	private User user;

	public CardList() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setU(User u) {
		this.user = u;
	}

	@Override
	public String toString() {
		return "CardList [Id=" + id + ", title=" + title + ", userId=" + user.getId() + "]";
	}

}
