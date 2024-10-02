package com.br.dto;

public class SelectStoreDto {
	private int storeIdx;
    private String storeName;
    private String address;
    private String phone;
    private String businessHours;
    private String service;
    private String latitude;
    private String longitude;
    private String typeBr;
    private String parking;
    private String delivery;
    private String pickup;
    private String here;
    private String happyStation;
    private String blindBox;
    
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
