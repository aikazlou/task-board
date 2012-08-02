package org.exadel.task.board.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;



@Entity
@Table(name = "Card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String content;

	private String type;

	@ManyToOne
	@JoinColumn(name = "authorId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "listId")
	private CardList cardList;	

	@OneToMany 
	@JoinColumn (name  = "cardId")
	private List<Comment> commentList;
	

	public Card() {

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

	public User getUser() {
		return user;
	}

	public void setU(User user) {
		this.user = user;
	}

	public CardList getCardList() {
		return cardList;
	}

	public void setList(CardList cardList) {
		this.cardList = cardList;
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", title=" + title + ", content=" + content + ", type=" + type
				+ ", userId=" + user.getId() + ", listId=" + cardList.getId() + "]";
	}

}
