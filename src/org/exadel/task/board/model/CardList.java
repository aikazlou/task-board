package org.exadel.task.board.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.*;

@Entity
@Table(name = "LISTS")
public class CardList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "TITLE")
	private String title;

	@OneToMany(cascade = { CascadeType.REMOVE })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "LIST_ID", nullable = false)
	private final List<Card> cards = new LinkedList<Card>();

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private User user;

	public CardList() {
	}
	
	public boolean addCard(Card card) {
		return cards.add(card);
	}
	
	public boolean removeCard(Card card) {
		return cards.remove(card);
	}
	
	public boolean contains( Card card) {
		return cards.contains(card);
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

	public void setUser(User user) {
		this.user = user;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return "List [Id=" + id + ", title=" + title + ", userId="
				+ user.getId() + "]";
	}

}
