package org.exadel.task.board.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "List")
public class List {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String title;
	@ManyToOne
	@JoinColumn(name="authorId")
	private User u;
	//private int authorId;

	public List() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String toString() {
		return "List [Id=" + Id + ", title=" + title + ", userId=" + u.getId() + "]";
	}

	
	
//	public int getAuthorId() {
//		return authorId;
//	}
//
//	public void setAuthorId(int authorId) {
//		this.authorId = authorId;
//	}

}
