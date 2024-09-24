package com.br.dto;

public class StoreDto {
	private int storeIdx;
	private String storeName;
	private String address;
	private String phone;
	private String businessHours;
	private String service;

	public StoreDto() {

	}
	
	public StoreDto(int storeIdx, String storeName, String address, String phone, String businessHours,
			String service) {
		super();
		this.storeIdx = storeIdx;
		this.storeName = storeName;
		this.address = address;
		this.phone = phone;
		this.businessHours = businessHours;
		this.service = service;
	}
	
	public int getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(int storeIdx) {
		this.storeIdx = storeIdx;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
}
