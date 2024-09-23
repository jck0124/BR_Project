package com.br.dto;

public class DrinkDetailMenuDto {
	
	private String name;
	private String servingSize;
	private String calories;
	private String sugars;
	private String protein;
	private String saturatedFat;
	private String sodium;
	private String caffeine;
	private String allergens;
	private int price;
	
	
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
