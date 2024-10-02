package com.br.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.StoreDao;
import com.br.dto.SelectStoreDto;
import com.br.dto.StoreDto;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDao sDao;
	
	@Override
	public ArrayList<StoreDto> getStoreList() {
		ArrayList<StoreDto> storeList = new ArrayList<StoreDto>();
	
		storeList = sDao.selectStoreList();
		
		return storeList;
	}

	@Override
	public ArrayList<SelectStoreDto> getStore() {
		ArrayList<SelectStoreDto> selectStore = new ArrayList<SelectStoreDto>();
		selectStore = sDao.selectStore();
		return selectStore;
	}
}
