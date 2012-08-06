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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "CARDS")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CONTENT")
	private String content;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private User author;

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CARD_ID", nullable = false)
	private final List<Comment> comments = new LinkedList<Comment>();

	public Card() {
	}

	public Card(String title, String type, String content, User author) {
		this.title = title;
		this.type = type;
		this.content = content;
		this.author = author;
	}

	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}

	public boolean removeComment(Comment comment) {
		return comments.remove(comment);
	}

	public List<Comment> getComments() {
		return new LinkedList<Comment>(comments);
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", type=" + type
				+ ", content=" + content + ", authorId=" + author.getId() + "]";
	}

}
