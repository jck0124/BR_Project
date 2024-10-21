package com.br.dto;

// 메뉴(아이스크림)
public class IcecreamDto {
	
	private int icecreamIdx;	// 아이스크림 idx
    private String nameKor;	// 메뉴명(한글)
    private String nameEng;	// 메뉴명(영어)
    private String imgUrl;	// 이미지 URL
    private String detailImg;	// 상세 이미지 URL
    private String info;	// 설명
    private String hashtag;	// 해시태그
    private String backgroundColor;	// 배경색
    private String textColor;	// 글자색
    private int orderNum;	// 메뉴 순번
    private int servingSize;	// 1회 제공량
    private int calories;	// 열량
    private int sugars;	// 당류
    private int protein;	// 단백질
    private int saturatedFat;	// 포화지방
    private int sodium;	// 나트륨
    private String allergens;	// 알레르기
    
	public IcecreamDto(){
		
	}
    
	public IcecreamDto(int icecreamIdx, String nameKor, String nameEng, String imgUrl, String detailImg, String info,
			String hashtag, String backgroundColor, String textColor, int orderNum, int servingSize, int calories,
			int sugars, int protein, int saturatedFat, int sodium, String allergens) {
		super();
		this.icecreamIdx = icecreamIdx;
		this.nameKor = nameKor;
		this.nameEng = nameEng;
		this.imgUrl = imgUrl;
		this.detailImg = detailImg;
		this.info = info;
		this.hashtag = hashtag;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.orderNum = orderNum;
		this.servingSize = servingSize;
		this.calories = calories;
		this.sugars = sugars;
		this.protein = protein;
		this.saturatedFat = saturatedFat;
		this.sodium = sodium;
		this.allergens = allergens;
	}
	
	public int getIcecreamIdx() {
		return icecreamIdx;
	}
	
	public void setIcecreamIdx(int icecreamIdx) {
		this.icecreamIdx = icecreamIdx;
	}
	
	public String getNameKor() {
		return nameKor;
	}
	
	public void setNameKor(String nameKor) {
		this.nameKor = nameKor;
	}
	
	public String getNameEng() {
		return nameEng;
	}
	
	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getDetailImg() {
		return detailImg;
	}
	
	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getHashtag() {
		return hashtag;
	}
	
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public String getTextColor() {
		return textColor;
	}
	
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public int getServingSize() {
		return servingSize;
	}
	
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public int getSugars() {
		return sugars;
	}
	
	public void setSugars(int sugars) {
		this.sugars = sugars;
	}
	
	public int getProtein() {
		return protein;
	}
	
	public void setProtein(int protein) {
		this.protein = protein;
	}
	
	public int getSaturatedFat() {
		return saturatedFat;
	}
	
	public void setSaturatedFat(int saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	
	public int getSodium() {
		return sodium;
	}
	
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	
	public String getAllergens() {
		return allergens;
	}
	
	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}
    
}
