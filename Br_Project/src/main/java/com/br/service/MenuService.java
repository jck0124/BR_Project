package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;
import com.br.dto.ShowIceCreamCakeDetailDto;

public interface MenuService {
	
	// 찬균
	ArrayList<DrinkDto> getDrinksList();
	DrinkDetailDto getDrinkDetail(int drinksIDx);
	
	// 수연
	ArrayList<IcecreamDto> getIcecreamList();
	
	// 수빈
	
	// 아이스크림 케이크 목록
	Map<String, Object> showIceCreamCake(int pageNum);
	// 아이스크림 케이크 상세정보
	ShowIceCreamCakeDetailDto showIceCreamCakeDetail(String korName);
}
