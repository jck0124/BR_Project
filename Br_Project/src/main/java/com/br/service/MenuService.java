package com.br.service;

import java.util.ArrayList;

import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkDto;

public interface MenuService {
	
	ArrayList<DrinkDto> getDrinksList();
	
	DrinkDetailDto getDrinkDetail(int drinksIDx);
	
}
