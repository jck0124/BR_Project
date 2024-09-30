package com.br.dao;

import java.util.ArrayList;

import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;
import com.br.dto.IcecreamIngredientDto;
import com.br.dto.ShowIceCreamCakeDetailDto;
import com.br.dto.ShowIceCreamCakeDto;

public interface MenuDao {
	
	// 음료 리스트 SELECT
	ArrayList<DrinkDto> selectDrinksList();
	
	// 특정 idx의 음료 SELECT
	DrinkDto selectDrinkByIdx(int drinksIdx);
	
	// 특정 idx의 음료 세부 메뉴 리스트 SELECT
	ArrayList<DrinkDetailMenuDto> selectDrinkDetailMenuList(int drinksIdx);
	
	// 아이스크림 리스트
	ArrayList<IcecreamDto> selectIcecreamList(int pageNum);
	
	// 아이스크림 라스트 페이지 넘버
	int getIcecreamLastPageNumber();
	
	// 아이스크림 상세페이지
	IcecreamDto selectIcecreamDetail(int icecreamIdx); 
	
	// 아이스크림 재료
	ArrayList<IcecreamIngredientDto> selectIngredientList(int icecreamIdx);
	
	// 아이스크림 케이크 리스트
	ArrayList<ShowIceCreamCakeDto> showIceCreamCake(int pageNum);
	// 아이스크림 케이크 리스트 페이지네이션 
	int getLastPageNumber();
	// 아이스크림 케이크 디테일
	ShowIceCreamCakeDetailDto showIceCreamCakeDetail(String korName);
	
}
