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
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "CARDS")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NaturalId
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private User user;
	
	@NaturalId 
	@Column (name = "TIME_STAMP")
	private long timestamp;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "TYPE")
	private String type;


	@Column(name = "CONTENT")
	private String content;




	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CARD_ID", nullable = false)
	private final List<Comment> comments = new LinkedList<Comment>();


		

	Card() {
		// default constructor for ORM
		
	}
		
	public Card(User user) {
		this.user = user;
		timestamp = System.currentTimeMillis();

	}
	
	
	

	public Card(User user, String title, String type, String content) {
		this.user = user;
		this.title = title;
		this.type = type;
		this.content = content;
		timestamp = System.currentTimeMillis();
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

	
	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", type=" + type
				+ ", content=" + content +"]";
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
		Card other = (Card) obj;
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
