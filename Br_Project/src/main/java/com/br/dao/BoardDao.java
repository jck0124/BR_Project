package com.br.dao;

import java.util.ArrayList;

import com.br.dto.PlazaBoardDto;
import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

public interface BoardDao {
	
	// 찬균
	ArrayList<PlazaBoardDto> selectPlazaBoardList();
	
	
	// 수연
	//모든 레시피 목록
	ArrayList<RecipeDto> selectRecipeList();	
	// 등록될 레시피idx
	int selectRecipeIdx();	
	void insertRecipe(int insertRecipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng);
	
	// 수빈
	
	// 이벤트 목록 
	ArrayList<SelectEventDto> selectEvent(int pageNum);
	
	// 이벤트 lastPage
	int getLastPageNumber();
	
	// 이벤트 insert
	void insertEvent(String img, String topLetter, String title, String period);
}
