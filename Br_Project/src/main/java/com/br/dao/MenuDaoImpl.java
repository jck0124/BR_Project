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
import com.br.dto.ShowIceCreamCakeDetailDto;
import com.br.dto.ShowIceCreamCakeDto;

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
	// 아이스크림 리스트 
	@Override
	public ArrayList<ShowIceCreamCakeDto> showIceCreamCake(int pageNum) {
		int endNum = pageNum * 10;
		int startNum = endNum -9;
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("endNum", endNum);
		hmap.put("startNum", startNum);
		
		List<ShowIceCreamCakeDto> cakesListTemp = sqlSession.selectList("MenuMapper.selectAllCakes", hmap);
		ArrayList<ShowIceCreamCakeDto> cakesList = new ArrayList<ShowIceCreamCakeDto>();
		cakesList.addAll(cakesListTemp);
		return cakesList;
	}
	
	// 아이스크림 리스트 페이지네이션
	@Override
	public int getLastPageNumber() {
		int countRet = sqlSession.selectOne("MenuMapper.selectLastPageNumber");
		return countRet/10 + (countRet%10>0 ? 1 : 0);
	}
	
	// 아이스크림 디테일
	@Override
	public ShowIceCreamCakeDetailDto showIceCreamCakeDetail(String korName) {
		// 이전의 pstmt의 역할로 hashmap 사용
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("korName", korName);
		
		ShowIceCreamCakeDetailDto cakeDetail = sqlSession.selectOne("MenuMapper.showCakeDetail", hmap);
		return cakeDetail;
	}

}
