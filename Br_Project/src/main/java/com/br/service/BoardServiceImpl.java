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
import com.br.dto.RecipeImgDto;
import com.br.dto.SelectEventDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;
	
	
	// 배라광장 게시글 목록
	@Override
	public PlazaPaginationDto palzaPagination(String orderType, int pageNum) {

		ArrayList<PlazaBoardDto> boardList;
		boardList = orderType.equals("likes") 
					? bDao.selectPlazaBoardListOrderByLikes()
					: bDao.selectPlazaBoardListOrderByLatest(); 
		
		int totalPageNum = 1;

		if (boardList.size() % 8 != 0) {
			totalPageNum = boardList.size() / 8 + 1;
		} else {
			totalPageNum = boardList.size() / 8;
		}

		ArrayList<PlazaBoardDto> paginationBoardList = new ArrayList<PlazaBoardDto>();

		if (pageNum != totalPageNum) {
			for (int i = (pageNum - 1) * 8; i <= (pageNum * 8 - 1); i++) {
				paginationBoardList.add(boardList.get(i));
			}
		} else {
			for (int i = (pageNum - 1) * 8; i < boardList.size(); i++) {
				paginationBoardList.add(boardList.get(i));
			}
		}

		return new PlazaPaginationDto(orderType, totalPageNum, paginationBoardList);
	}

	// 배라광장 게시글 작성
	@Override
	public void insertPlazaBoard(String title, String content, String writerId, String writerName, String showName) {
		
		char showNameChar = 'F';
		
		if(showName.equals("agree")) {
			showNameChar = 'T';
		}
		
		bDao.insertPlaza(title, content, writerId, writerName, showNameChar);
	}

	// 배라광장 추천버튼
	@Override
	public void increaseLikes(int boardIdx) {
		
		bDao.updatePlazaLikes(boardIdx);
	}	
	
	// 레시피 출력
	@Override
	public ArrayList<RecipeDto> getRecipeList() {
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		// 메서드 실행시 트랜잭션 관리
		recipeList = bDao.selectRecipeList();

		return recipeList;
	}
	
	// 레시피 idx
	@Override
	public int getRecipeIdx() {
		int recipeIdx = bDao.selectRecipeIdx();
		
		return recipeIdx;
	}
	
	// 레시피 insert
	@Override
	public void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng) {
		bDao.insertRecipe(recipeIdx, categoryIdx, imgUrl, titleKor, titleEng);
	}
	
	// 레시피 이미지
	@Override
	public RecipeImgDto getRecipeImg(int recipeIdx) {
		return bDao.selectRecipeImg(recipeIdx);
	}
	
	// event 게시판 보여주기
	@Override
	public Map<String, Object> selectEvent(int pageNum) {
		// 무한스크롤
//	System.out.println(pageNum);
//			
		ArrayList<SelectEventDto> selectEvent = new ArrayList<SelectEventDto>();
		selectEvent = bDao.selectEvent(pageNum);
//			
//			JSONArray array = new JSONArray();
//			for(SelectEventDto dto : selectEvent) {
//				JSONObject obj = new JSONObject();
//				obj.put("img", dto.getImg());
//				obj.put("topLetter", dto.getTopLetter());
//				obj.put("title", dto.getTitle());
//				obj.put("period", dto.getPeriod());
//				array.add(obj);
//			}
//			response.setContentType("application/json; charset=utf-8");
//			

		// 페이지네이션
		int startNum, endNum;
		int lastPageNum = bDao.getLastPageNumber();
		endNum = (pageNum / 5 + 1) * 5 - (pageNum % 5 == 0 ? 5 : 0);
		if (endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		startNum = endNum - 4;

		Map<String, Object> result = new HashMap<>();
		result.put("selectEvent", selectEvent);
		result.put("startNum", startNum);
		result.put("endNum", endNum);
		result.put("lastPageNum", lastPageNum);

		return result;
	}

	@Override
	public void insertEvent(String imgPath, String topLetter, String title, String period) {

		bDao.insertEvent(imgPath, topLetter, title, period);
	}

}
