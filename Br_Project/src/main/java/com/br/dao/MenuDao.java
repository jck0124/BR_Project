package com.br.dao;

import java.util.ArrayList;

import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;

public interface MenuDao {
	
	// 음료 리스트 SELECT
	ArrayList<DrinkDto> selectDrinksList();
	
	// 특정 idx의 음료 SELECT
	DrinkDto selectDrinkByIdx(int drinksIdx);
	
	// 특정 idx의 음료 세부 메뉴 리스트 SELECT
	ArrayList<DrinkDetailMenuDto> selectDrinkDetailMenuList(int drinksIdx);
	
	// 아이스크림 리스트
	ArrayList<IcecreamDto> selectIcecreamList();
	
}
