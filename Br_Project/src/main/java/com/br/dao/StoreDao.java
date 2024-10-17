package com.br.dao;

import java.util.ArrayList;

import com.br.dto.*;

public interface StoreDao {
	ArrayList<StoreDto> selectStoreList();	// 모든 매장 목록
	
	ArrayList<StoreDto> filteredStoreList(
			String storeTypeBrChecked,
			String storeTypeFlavor,
			String parkingChecked,
			String deliveryChecked,
			String pickupChecked,
			String hereChecked,
			String happyStationChecked,
			String blindBoxChecked,
			String sel1Selected,
			String sel2Selected,
			String storeSearched
			);	// 필터링된 매장 목록
	
	ArrayList<SelectStoreDto> selectStore(); //매장 목록 (최종본)
	
	// 음료 리스트 SELECT
	ArrayList<DrinkDto> selectDrinksList();
	
	// 아이스크림 리스트
	ArrayList<IcecreamDto> selectIcecreamList();
	
	// 아이스크림 케이크 리스트
	ArrayList<ShowIceCreamCakeDto> showIceCreamCake();
}
