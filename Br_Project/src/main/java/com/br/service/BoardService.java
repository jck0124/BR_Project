package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.PlazaDetailDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;
import com.nimbusds.jose.shaded.json.JSONArray;

public interface BoardService {
	
	// 게시판(배라광장) 게시글 리스트
	// 파라미터: (orderType) / 현재 페이지(pageNum)
	PlazaPaginationDto palzaPagination(String orderType, int pageNum);
	
	// 게시판(배라광장) 게시글 작성
	// 파라미터: 제목(title) / 내용(content) / 작성자 아이디(writerId) / 작성자 이름(writerName) / (showName)
	void insertPlazaBoard(String title, String content, String writerId, String writerName, String showName);
	
	// 게시판(배라광장) 추천 버튼
	// 파라미터: 게시글 idx(boardIdx)
	void increaseLikes(int boardIdx);
	
	// 게시판(배라광장) 자세히 보기
	// 파라미터: 게시글 idx(boardIdx)
	PlazaDetailDto showPlazaDetailByBoardIdx(int boardIdx);
	
	// 게시판(레시피) 리스트
	ArrayList<RecipeDto> getRecipeList();
	
	// 게시판(레시피) 레시피 idx
	int getRecipeIdx();
	
	// 게시판(레시피) 등록
	// 파라미터: 레시피 idx(recipeIdx) / 카테고리 idx(categoryIdx) / 이미지 URL(imgUrl) / 타이틀(한국)(titleKor) / 타이틀(영어)(titleEng)
	void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng);
	
	// 게시판(레시피) 이미지
	// 파라미터: 레시피 idx(recipeIdx)
	RecipeImgDto getRecipeImg(int recipeIdx);
	
	// 게시판(이벤트) 리스트
	// 파라미터: 현재 페이지(pageNum)
	JSONArray selectEvent(int pageNum);
	
	// 게시판(이벤트) 등록
	// 파라미터: 이미지 경로(imgPath) / 종류(topLetter) / 제목(title) / 기간(period)
	void insertEvent(String imgPath, String topLetter, String title, String period);

}
