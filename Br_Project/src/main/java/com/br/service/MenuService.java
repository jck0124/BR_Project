package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkPaginationDto;
import com.br.dto.IcecreamDto;
import com.br.dto.IcecreamIngredientDto;
import com.br.dto.ShowIceCreamCakeDetailDto;

public interface MenuService {
	
	// 찬균
	// 특정 페이지 번호의 음료 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
	DrinkPaginationDto getPaginationDrinksList(int pageNum);
	
	// 특정 idx의 음료 상세 페이지
	// 파라미터: 음료idx(drinksIdx)
	DrinkDetailDto getDrinkDetail(int drinksIdx);
	
	// 수연
	// 특정 페이지 번호의 아이스크림 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
	Map<String, Object> getIcecreamList(int pageNum);
	
	// 특정 idx의 아이스크림 상세 페이지
	// 파라미터: 아이스크림idx(icecreamIdx)
	IcecreamDto getIcecreamDetail(int icecreamIdx);
	
	// 특정 idx의 아이스크림 재료
	// 파라미터: 아이스크림idx(icecreamIdx)
	ArrayList<IcecreamIngredientDto> getIngredient(int icecreamIdx);
	
	// 수빈
	// 특정 페이지 번호의 아이스크림케이크 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
	Map<String, Object> showIceCreamCake(int pageNum);
	
	// 특정 idx의 아이스크림케이크 상세 페이지
	// 변경 필요
	// 파라미터: 
	ShowIceCreamCakeDetailDto showIceCreamCakeDetail(int cakeIdx);
}
