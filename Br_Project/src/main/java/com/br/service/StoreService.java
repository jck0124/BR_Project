package com.br.service;

import java.util.ArrayList;

import com.br.dto.*;

public interface StoreService {
	ArrayList<StoreDto> getStoreList();
	
	ArrayList<SelectStoreDto> getStore();
}
