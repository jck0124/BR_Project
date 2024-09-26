package com.br.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.BoardDao;
import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;
	
	@Override
	public PlazaPaginationDto getPalzaPaginationDto(int pageNum) {
		
		int totalPageNum = 1;
		ArrayList<PlazaBoardDto> boardList = bDao.selectPlazaBoardList();
		
		if( boardList.size()%4 != 0 ) {
			totalPageNum = boardList.size()/4 + 1;
		} else {
			totalPageNum = boardList.size()/4;
		}
		
		ArrayList<PlazaBoardDto> paginationBoardList = new ArrayList<PlazaBoardDto>();
		
		
		if(pageNum != totalPageNum) {
			for(int i = (pageNum - 1)*8; i <= (pageNum*8 - 1); i++) {
				paginationBoardList.add( boardList.get(i) );
			}
		} else {
			for(int i = (pageNum - 1)*8; i < boardList.size(); i++) {
				paginationBoardList.add( boardList.get(i) );
			}
		}
		
		return new PlazaPaginationDto(totalPageNum, paginationBoardList);
	}
	
	
	@Override
	public ArrayList<RecipeDto> getRecipeList() {
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		
		// 메서드 실행시 트랜잭션 관리
		recipeList = bDao.selectRecipeList();
		
		return recipeList;
	}
	
	// event 게시판 보여주기
	@Override
	public Map<String,Object> selectEvent(int pageNum) {
		ArrayList<SelectEventDto> selectEvent = new ArrayList<SelectEventDto>();
		selectEvent = bDao.selectEvent(pageNum);
		
		int startNum, endNum;
		int lastPageNum = bDao.getLastPageNumber();
		endNum = (pageNum/5+1)*5 - (pageNum%5==0 ? 5 : 0);
		if(endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		startNum = endNum -4;
		
		Map<String,Object> result = new HashMap<>();
		result.put("selectEvent", selectEvent);
		result.put("startNum", startNum);
		result.put("endNum", endNum);
		result.put("lastPageNum", lastPageNum);
		
		return result;
	}
}
