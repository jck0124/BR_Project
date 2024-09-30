package com.br.dto;

import java.util.ArrayList;

public class PlazaPaginationDto {
	
	private String orderType;
	private int totalPageNum;
	private ArrayList<PlazaBoardDto> boardList;
	
	public PlazaPaginationDto() {
		
	}

	public PlazaPaginationDto(String orderType, int totalPageNum, ArrayList<PlazaBoardDto> boardList) {
		super();
		this.orderType = orderType;
		this.totalPageNum = totalPageNum;
		this.boardList = boardList;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
