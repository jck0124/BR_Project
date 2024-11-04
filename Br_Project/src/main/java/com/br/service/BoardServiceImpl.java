package com.br.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.BoardDao;
import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaDetailDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;
import com.br.dto.SelectEventDto;
import com.nimbusds.jose.shaded.json.JSONArray;

import net.minidev.json.JSONObject;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;
	
	
	// 게시판(배라광장) 게시글 리스트
	// 파라미터: (orderType) / 현재 페이지(pageNum)
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

	// 게시판(배라광장) 게시글 작성
	// 파라미터: 제목(title) / 내용(content) / 작성자 아이디(writerId) / 작성자 이름(writerName) / (showName)
	@Override
	public void insertPlazaBoard(String title, String content, String writerId, String writerName, String showName) {
		
		char showNameChar = 'F';
		
		if(showName.equals("agree")) {
			showNameChar = 'T';
		}
		
		bDao.insertPlaza(title, content, writerId, writerName, showNameChar);
	}

	// 게시판(배라광장) 추천버튼
	// 파라미터: 게시글 idx(boardIdx)
	@Override
	public void increaseLikes(int boardIdx) {
		
		bDao.updatePlazaLikes(boardIdx);
	
	}	
	
	// 게시판(배라광장) 자세히 보기
	// 파라미터: 게시글 idx(boardIdx)
	@Override
	public PlazaDetailDto showPlazaDetailByBoardIdx(int boardIdx) {
		
		PlazaDetailDto pDto = bDao.selectPlazaDtoByBoardIdx(boardIdx);
		if(pDto.getShowName() == 'F') {
			pDto.setWriterName("비공개");
		}
		
		return pDto;
	}
	
	// 게시판(레시피) 리스트
	@Override
	public ArrayList<RecipeDto> getRecipeList() {
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		recipeList = bDao.selectRecipeList();

		return recipeList;
	}
	
	// 게시판(레시피) 레시피 idx
	@Override
	public int getRecipeIdx() {
		int recipeIdx = bDao.selectRecipeIdx();
		
		return recipeIdx;
	}
	
	// 게시판(레시피) 등록
	// 파라미터: 레시피 idx(recipeIdx) / 카테고리 idx(categoryIdx) / 이미지 URL(imgUrl) / 타이틀(한국)(titleKor) / 타이틀(영어)(titleEng)
	@Override
	public void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng) {
		bDao.insertRecipe(recipeIdx, categoryIdx, imgUrl, titleKor, titleEng);
	}
	
	// 게시판(레시피) 이미지
	// 파라미터: 레시피 idx(recipeIdx)
	@Override
	public RecipeImgDto getRecipeImg(int recipeIdx) {
		return bDao.selectRecipeImg(recipeIdx);
	}
	
	// 게시판(이벤트) 리스트
	// 파라미터: 현재 페이지(pageNum)
	@Override
	public JSONArray selectEvent(int pageNum) {
		
		ArrayList<SelectEventDto> selectEvent = new ArrayList<SelectEventDto>();
		selectEvent = bDao.selectEvent(pageNum);

		int lastPageNum = bDao.getLastPageNumber();
		int endNum = (pageNum / 5 + 1) * 5 - (pageNum % 5 == 0 ? 5 : 0);
		if (endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		int startNum = endNum - 4;
		
		JSONArray array = new JSONArray();
		for(SelectEventDto dto : selectEvent) {
			JSONObject obj = new JSONObject();
			obj.put("img", dto.getImg());
			obj.put("topLetter", dto.getTopLetter());
			obj.put("title", dto.getTitle());
			obj.put("period", dto.getPeriod());
			array.add(obj);
		}
		
		return array;
	}
	
	// 게시판(이벤트) 등록
	// 파라미터: 이미지 경로(imgPath) / 종류(topLetter) / 제목(title) / 기간(period)
	@Override
	public void insertEvent(String imgPath, String topLetter, String title, String period) {
		bDao.insertEvent(imgPath, topLetter, title, period);
	}

}
