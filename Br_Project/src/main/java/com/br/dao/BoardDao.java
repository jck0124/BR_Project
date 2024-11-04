package com.br.dao;

import java.util.ArrayList;

import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaDetailDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;
import com.br.dto.SelectEventDto;

public interface BoardDao {
	
	// 찬균
	
	// 배라광장 게시글 리스트 최신순
	ArrayList<PlazaBoardDto> selectPlazaBoardListOrderByLatest();
	
	// 배라광장 게시글 리스트 추천순 
	ArrayList<PlazaBoardDto> selectPlazaBoardListOrderByLikes();
	
	// 배라광장 게시글 작성
	void insertPlaza(String title, String content, String id, String name, char showName);
	
	// 배라광장 게시글 추천
	void updatePlazaLikes(int boardIdx);
	
	PlazaDetailDto selectPlazaDtoByBoardIdx(int boardIdx);
	
	// 수연
	
	// 게시판(레시피) 리스트
	ArrayList<RecipeDto> selectRecipeList();	
	
	// 게시판(레시피) 신규 레시피 idx
	int selectRecipeIdx();	
	
	// 게시판(레시피) 등록
	// 파라미터: 레시피 idx(recipeIdx) / 카테고리 idx(categoryIdx) / 이미지 URL(imgUrl) / 타이틀(한글)(titleKor) / 타이틀(영어)(titleEng)
	void insertRecipe(int insertRecipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng);
	
	// 게시판(레시피) 이미지 
	// 파라미터: 레시피 idx(recipeIdx)
	RecipeImgDto selectRecipeImg(int recipeIdx);
	
	// 수빈
	
	// 게시판(이벤트) 리스트 
	// 파라미터: 현재 페이지번호(pageNum)
	ArrayList<SelectEventDto> selectEvent(int pageNum);
	
	// 게시판(이벤트) 마지막 숫자
	int getLastPageNumber();
	
	// 게시판(이벤트) 등록
	// 파라미터: 이미지 URL(img) / 종류(topLetter) / 제목(title) / 기간(period)
	void insertEvent(String img, String topLetter, String title, String period);
}
