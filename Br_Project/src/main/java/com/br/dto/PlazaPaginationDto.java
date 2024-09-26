package com.br.dto;

import java.util.ArrayList;

public class PlazaPaginationDto {

	private int totalPagenum;
	private ArrayList<PlazaBoardDto> boardList;
	
	public PlazaPaginationDto() {
		
	}

	public PlazaPaginationDto(int totalPagenum, ArrayList<PlazaBoardDto> boardList) {
		super();
		this.totalPagenum = totalPagenum;
		this.boardList = boardList;
	}

	public int getTotalPagenum() {
		return totalPagenum;
	}

	public void setTotalPagenum(int totalPagenum) {
		this.totalPagenum = totalPagenum;
	}

	public ArrayList<PlazaBoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<PlazaBoardDto> boardList) {
		this.boardList = boardList;
	}
	
	
	
}
