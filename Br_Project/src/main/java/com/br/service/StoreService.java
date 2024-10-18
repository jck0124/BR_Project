package com.br.service;

import java.util.ArrayList;
import java.util.Map;

import com.br.dto.SelectStoreDto;
import com.br.dto.StoreDto;

public interface StoreService {
	// 필터링 전 store
	ArrayList<StoreDto> getStoreList();
	
	// 필터링 후 store
	ArrayList<StoreDto> getFilteredStoreList(
			Boolean storeTypeBrChecked,
			Boolean storeTypeFlavor,
			Boolean parkingChecked,
			Boolean deliveryChecked,
			Boolean pickupChecked,
			Boolean hereChecked,
			Boolean happyStationChecked,
			Boolean blindBoxChecked,
			String sel1Selected,
			String sel2Selected,
			String storeSearched
			);
	
	ArrayList<SelectStoreDto> getStore();
	
	// order_list 리스트 취합 
	Map<String, Object> getProducts();
	

}
