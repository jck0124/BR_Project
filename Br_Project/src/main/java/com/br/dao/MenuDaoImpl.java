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
import com.br.dto.IcecreamIngredientDto;
import com.br.dto.ShowIceCreamCakeDetailDto;
import com.br.dto.ShowIceCreamCakeDto;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 찬균
	// 음료 리스트 
	@Override
	public ArrayList<DrinkDto> selectDrinksList() {
		
		List<DrinkDto> drinksList = sqlSession.selectList("MenuMapper.selectAllDrinks");
		
		return new ArrayList<DrinkDto>(drinksList);
	}
	
	// 특정 idx의 음료 정보 
	// 파라미터: 음료idx(drinksIdx)
	@Override
	public DrinkDto selectDrinkByIdx(int drinksIdx) {
		return sqlSession.selectOne("MenuMapper.selectDrink", drinksIdx);
	}
	
	// 특정 idx 음료의 옵션 리스트
	// 파라미터: 음료idx(drinksIdx)
	@Override
	public ArrayList<DrinkDetailMenuDto> selectDrinkDetailMenuList(int drinksIdx) {
		
		List<DrinkDetailMenuDto> drinkDetailMenuList = sqlSession.selectList("MenuMapper.selectDrinkDetailMenu", drinksIdx);
		
		return new ArrayList<DrinkDetailMenuDto>(drinkDetailMenuList); 
	}
	
	// 수연
	// 아이스크림 리스트 페이지네이션
	// 파라미터: 현재 페이지(pageNum)
	@Override
	public ArrayList<IcecreamDto> selectIcecreamList(int pageNum) {
		
		int endNum = pageNum * 10;
		int startNum = endNum - 9;
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("endNum", endNum);
		hmap.put("startNum", startNum);
		
		List<IcecreamDto> icecreamListTemp = sqlSession.selectList("MenuMapper.getAllIcecream", hmap);
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList.addAll(icecreamListTemp);
		
		return icecreamList;
	}
	
	// 아이스크림 마지막 페이지 번호
	@Override
	public int getIcecreamLastPageNumber() {
		int countRet = sqlSession.selectOne("MenuMapper.selectIcecreamLastPageNum");
		
		return countRet/10 + (countRet%10>0 ? 1 : 0);
	}
	
	// 특정 idx의 아이스크림
	// 파라미터: 아이스크림idx(icecreamIdx)
	@Override
	public IcecreamDto selectIcecreamDetail(int icecreamIdx) {
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("icecreamIdx", icecreamIdx);
		
		IcecreamDto icecreamDetail =  sqlSession.selectOne("MenuMapper.getIcecreamDetail", hmap);
		
		return icecreamDetail;
	
	}
	
	// 특정 idx의 아이스크림 재료
	// 파라미터: 아이스크림idx(icecreamIdx)
	@Override
	public ArrayList<IcecreamIngredientDto> selectIngredientList(int icecreamIdx) {
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("icecreamIdx", icecreamIdx);
		
		List<IcecreamIngredientDto> ingredientListTemp = sqlSession.selectList("MenuMapper.getIngredient", hmap);
		
		return new ArrayList<IcecreamIngredientDto>(ingredientListTemp);
	}
	
	// 수빈
	// 아이스크림케이크 리스트 페이지네이션
	// 파라미터: 현재 페이지(pageNum)
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
	
	// 아이스크림케이크 마지막 페이지 번호
	@Override
	public int getLastPageNumber() {
		
		int countRet = sqlSession.selectOne("MenuMapper.selectLastPageNumber");
		
		return countRet/10 + (countRet%10>0 ? 1 : 0);
	}
	
	// 특정 idx의 아이스크림케이크
	// 파라미터: 아이스크림케이크idx(cakeIdx)
	@Override
	public ShowIceCreamCakeDetailDto showIceCreamCakeDetail(int cakeIdx) {
		
		// 이전의 pstmt의 역할로 hashmap 사용
		HashMap<String,Integer> hmap = new HashMap<String, Integer>();
		hmap.put("cakeIdx", cakeIdx);
		
		ShowIceCreamCakeDetailDto cakeDetail = sqlSession.selectOne("MenuMapper.showCakeDetail", hmap);
		
		return cakeDetail;
	}

}
