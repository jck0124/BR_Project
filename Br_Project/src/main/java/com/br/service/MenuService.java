package com.br.service;

import java.util.ArrayList;

import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;

public interface MenuService {
	
	// 찬균
	ArrayList<DrinkDto> getDrinksList();
	DrinkDetailDto getDrinkDetail(int drinksIDx);
	
	// 수연
	ArrayList<IcecreamDto> getIcecreamList();
	
	// 수빈
}
