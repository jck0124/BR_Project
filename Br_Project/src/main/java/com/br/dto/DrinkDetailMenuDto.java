package com.br.dto;

// 음료 상세 정보
public class DrinkDetailMenuDto {
	
	private String name;	// 메뉴명
	private String servingSize;	// 1회 제공량
	private String calories;	// 열량
	private String sugars;	// 당류
	private String protein;	// 단백질
	private String saturatedFat;	// 포화지방
	private String sodium;	// 나트륨
	private String caffeine;	// 카페인
	private String allergens;	// 알레르기
	private int price;	// 가격
	
	
	public DrinkDetailMenuDto() {
		
	}

	public DrinkDetailMenuDto(String name, String servingSize, String calories, String sugars, String protein,
			String saturatedFat, String sodium, String caffeine, String allergens, int price) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.sugars = sugars;
		this.protein = protein;
		this.saturatedFat = saturatedFat;
		this.sodium = sodium;
		this.caffeine = caffeine;
		this.allergens = allergens;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getSugars() {
		return sugars;
	}

	public void setSugars(String sugars) {
		this.sugars = sugars;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getSaturatedFat() {
		return saturatedFat;
	}

	public void setSaturatedFat(String saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public String getSodium() {
		return sodium;
	}

	public void setSodium(String sodium) {
		this.sodium = sodium;
	}

	public String getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(String caffeine) {
		this.caffeine = caffeine;
	}

	public String getAllergens() {
		return allergens;
	}

	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
