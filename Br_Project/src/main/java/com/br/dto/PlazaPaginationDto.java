package com.br.dto;

import java.util.ArrayList;

public class PlazaPaginationDto {

	private int totalPageNum;
	private ArrayList<PlazaBoardDto> boardList;
	
	public PlazaPaginationDto() {
		
	}

	public PlazaPaginationDto(int totalPageNum, ArrayList<PlazaBoardDto> boardList) {
		super();
		this.totalPageNum = totalPageNum;
		this.boardList = boardList;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public ArrayList<PlazaBoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<PlazaBoardDto> boardList) {
		this.boardList = boardList;
	}
	
	
	
}
