package com.br.dto;

// 매장 지도 상세 정보
public class SelectStoreDto {
	
	private int storeIdx;	// 매장 idx
    private String storeName;	// 매장명
    private String address;	// 주소
    private String phone;	// 번호
    private String businessHours;	// 영업시간
    private String service;	// 서비스
    private String latitude;	// 위도
    private String longitude;	// 경도
    private String typeBr;	// 매장 타입
    private String parking;	// 주차
    private String delivery;	// 배달
    private String pickup;	// 픽업
    private String here;	// 취식
    private String happyStation;	// 해피스테이션
    private String blindBox;	// 가챠 머신
    
    public SelectStoreDto() {}
    
	public SelectStoreDto(int storeIdx, String storeName, String address, String phone, String businessHours,
			String service, String latitude, String longitude, String typeBr, String parking, String delivery,
			String pickup, String here, String happyStation, String blindBox) {
		super();
		this.storeIdx = storeIdx;
		this.storeName = storeName;
		this.address = address;
		this.phone = phone;
		this.businessHours = businessHours;
		this.service = service;
		this.latitude = latitude;
		this.longitude = longitude;
		this.typeBr = typeBr;
		this.parking = parking;
		this.delivery = delivery;
		this.pickup = pickup;
		this.here = here;
		this.happyStation = happyStation;
		this.blindBox = blindBox;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTypeBr() {
		return typeBr;
	}

	public void setTypeBr(String typeBr) {
		this.typeBr = typeBr;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getHere() {
		return here;
	}

	public void setHere(String here) {
		this.here = here;
	}

	public String getHappyStation() {
		return happyStation;
	}

	public void setHappyStation(String happyStation) {
		this.happyStation = happyStation;
	}

	public String getBlindBox() {
		return blindBox;
	}

	public void setBlindBox(String blindBox) {
		this.blindBox = blindBox;
	}
    
}
