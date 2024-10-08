package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.PlazaDetailDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;

public interface BoardService {
	
	// 배라광장
	PlazaPaginationDto palzaPagination(String orderType, int pageNum);
	
	// 배라광장 게시글 작성
	void insertPlazaBoard(String title, String content, String writerId, String writerName, String showName);
	
	// 배라광장 추천 버튼
	void increaseLikes(int boardIdx);
	
	// 배라광장 자세히 보기
	PlazaDetailDto showPlazaDetailByBoardIdx(int boardIdx);
	
	// 레시피 리스트
	ArrayList<RecipeDto> getRecipeList();
	
	// 레시피 등록될 idx
	int getRecipeIdx();
	
	// 레시피 이미지
	RecipeImgDto getRecipeImg(int recipeIdx);
	
	// 레시피 insert
	void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng);
	
	// 이벤트 리스트 보여주기
	Map<String,Object> selectEvent(int pageNum);
	
	// event insert
	void insertEvent(String imgPath, String topLetter, String title, String period);

}
