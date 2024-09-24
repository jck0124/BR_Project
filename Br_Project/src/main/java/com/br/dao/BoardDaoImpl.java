package com.br.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.dto.RecipeDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<RecipeDto> selectRecipeList() {
		
		List<RecipeDto> recipeListTemp = sqlSession.selectList("BoardMapper.getAllRecipe");
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		recipeList.addAll(recipeListTemp);
		
		return recipeList;
	}
	
}
