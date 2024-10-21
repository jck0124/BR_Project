package com.br.dto;

// 매장
public class StoreDto {
	
	private int storeIdx;	// 매장 idx
	private String storeName;	// 매장명
	private double latitude;	// 위도
	private double longitude;	// 경도
	private String address;	// 주소
	private String phone;	// 번호
	private String businessHours;	// 영업시간
	
	public StoreDto() {
		
	}
	
	public StoreDto(int storeIdx, String storeName, double latitude, double longitude, String address, String phone,
			String businessHours) {
		super();
		this.storeIdx = storeIdx;
		this.storeName = storeName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.phone = phone;
		this.businessHours = businessHours;
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
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	
}
