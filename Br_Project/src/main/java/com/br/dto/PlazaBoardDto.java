package com.br.dto;

public class PlazaBoardDto {
	
	private int boardIdx;
	private String title;
	private String content;
	private String writerId;
	private boolean newMark;
	private int likes;
	private String writerName;
	private boolean showName;
	
	public PlazaBoardDto() {
		
	}

	public PlazaBoardDto(int boardIdx, String title, String content, String writerId, boolean newMark, int likes,
			String writerName, boolean showName) {
		super();
		this.boardIdx = boardIdx;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.newMark = newMark;
		this.likes = likes;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		// 아이디 앞자리 3글자 제외 *로 표시
		StringBuffer sb = new StringBuffer( writerId.substring(0, 3) );
		if(writerId.length() > 3) {
			for(int i = 0; i < writerId.length() - 3; i++) {
				sb.append("*");
			}
		}
		this.writerId = sb.toString();
	}

	public boolean isNewMark() {
		return newMark;
	}

	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public boolean isShowName() {
		return showName;
	}

	public void setShowName(boolean showName) {
		this.showName = showName;
	}
	
	
	
}
