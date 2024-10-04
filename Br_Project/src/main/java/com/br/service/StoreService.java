package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.*;

public interface StoreService {
	ArrayList<StoreDto> getStoreList();
	
	ArrayList<SelectStoreDto> getStore();
	
	// order_list 리스트 취합 
	Map<String, Object> getProducts();
	
	
}
