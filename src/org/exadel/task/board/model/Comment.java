package org.exadel.task.board.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "COMMENTS")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NaturalId
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private User user;

	@NaturalId
	@Column(name = "TIME_STAMP")
	private long timestamp;

	@Column(name = "CONTENT")
	private String content;

	Comment() {
	}

	public Comment(User user) {
		this.user = user;
		timestamp = System.currentTimeMillis();
	}

	public Comment(User user, String content) {
		this.user = user;
		this.content = content;
		timestamp = System.currentTimeMillis();
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		Comment other = (Comment) obj;
		if (timestamp != other.timestamp)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [Id=" + id + " ," + " cardId=" + ", content=" + content
				+ "]";
	}

}
