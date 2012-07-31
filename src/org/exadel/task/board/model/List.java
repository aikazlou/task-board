package org.exadel.task.board.model;

public class List {
	private Long Id;
	private String Title;
	private Long BoardId;
	private Long AuthorId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Long getBoardId() {
		return BoardId;
	}

	public void setBoardId(Long boardId) {
		BoardId = boardId;
	}

	public Long getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}

}
