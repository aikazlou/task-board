package org.exadel.task.board.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@NaturalId
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private final User user;

	@NaturalId
	@Column(name = "TIME_STAMP")
	private final long timestamp = System.currentTimeMillis();

	@Column(name = "TITLE")
	private String title;

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "LIST_ID", nullable = false)
	private final List<Card> cards = new LinkedList<Card>();

	public CardList(User user) {
		this.user = user;
	}

	public boolean addCard(Card card) {
		return cards.add(card);
	}

	public boolean removeCard(Card card) {
		return cards.remove(card);
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}

	public int getId() {
		return id;
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

	public List<Card> getCards() {
		return new LinkedList<Card>(cards);
	}

	@Override
	public String toString() {
		return "List [Id=" + id + ", title=" + title + ", userId="
				+ user.getId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		CardList other = (CardList) obj;
		if (timestamp != other.timestamp)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
