package org.exadel.task.board.model;

public class Card {
	private Long Id;
	private Long ListId;
	private Long AuthorId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getListId() {
		return ListId;
	}

	public void setListId(Long listId) {
		ListId = listId;
	}

	public Long getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}

}
