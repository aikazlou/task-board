package org.exadel.task.board.model;

public class Comment {

	private Long Id;
	private Long AuthorId;
	private Long CardId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}

	public Long getCardId() {
		return CardId;
	}

	public void setCardId(Long cardId) {
		CardId = cardId;
	}

}
