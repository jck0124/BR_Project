package com.br.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 찬균
	@Override
	public ArrayList<DrinkDto> selectDrinksList() {
		List<DrinkDto> drinksList = sqlSession.selectList("MenuMapper.selectAllDrinks");
		return new ArrayList<DrinkDto>(drinksList);
	}
	
	@Override
	public DrinkDto selectDrinkByIdx(int drinksIdx) {
		return sqlSession.selectOne("MenuMapper.selectDrink", drinksIdx);
	}
	
	@Override
	public ArrayList<DrinkDetailMenuDto> selectDrinkDetailMenuList(int drinksIdx) {
		List<DrinkDetailMenuDto> drinkDetailMenuList = sqlSession.selectList("MenuMapper.selectDrinkDetailMenu", drinksIdx);
		return new ArrayList<DrinkDetailMenuDto>(drinkDetailMenuList); 
	}
	
	// 수연
	@Override
	public ArrayList<IcecreamDto> selectIcecreamList() {
		
		List<IcecreamDto> icecreamListTemp = sqlSession.selectList("MenuMapper.getAllIcecream");
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList.addAll(icecreamListTemp);
		
		return icecreamList;
	}

	
	// 수빈
	
}
