package com.br.dto;

public class PlazaDetailDto {

	private int boardIdx;
	private String title;
	private String content;
	private String writerName;
	private char showName;
	
	
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
