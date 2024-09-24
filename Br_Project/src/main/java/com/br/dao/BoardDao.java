package com.br.dao;

import java.util.ArrayList;

import com.br.dto.RecipeDto;

public interface BoardDao {
	ArrayList<RecipeDto> selectRecipeList();	//모든 레시피 목록
}
