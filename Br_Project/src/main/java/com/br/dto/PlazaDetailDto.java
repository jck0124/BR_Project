package com.br.dto;

// 게시판(배라광장)
public class PlazaDetailDto {

	private int boardIdx;	// 게시글 idx
	private String title;	// 내용
	private String content;	// 내용
	private String writerName;	// 작성자
	private char showName;	// ???
	
	
	public PlazaDetailDto() {
		
	}


	public PlazaDetailDto(int boardIdx, String title, String content, String writerName, char showName) {
		super();
		this.boardIdx = boardIdx;
		this.title = title;
		this.content = content;
		this.writerName = writerName;
		this.showName = showName;
	}


	public int getBoardIdx() {
		return boardIdx;
	}


	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
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


	public String getWriterName() {
		return writerName;
	}


	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}


	public char getShowName() {
		return showName;
	}


	public void setShowName(char showName) {
		this.showName = showName;
	}
	
	
}
