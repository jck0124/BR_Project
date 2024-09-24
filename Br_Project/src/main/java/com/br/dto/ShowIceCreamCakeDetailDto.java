package com.br.dto;

public class ShowIceCreamCakeDetailDto {
	private String cakeImg;
    private String backgroundColor;
    private String pinkLetter;
    private String engName;
    private String korName;
    private String subtitle;
    private int price;
    private int oneTime;
    private int kcal;
    private double fat;
    private int sodium;
    private int sugar;
    private int protein;
    private String allergy;
    private String infoImg;
    
    public ShowIceCreamCakeDetailDto() {}

	public ShowIceCreamCakeDetailDto(String cakeImg, String backgroundColor, String pinkLetter, String engName,
			String korName, String subtitle, int price, int oneTime, int kcal, double fat, int sodium, int sugar,
			int protein, String allergy, String infoImg) {
		super();
		this.cakeImg = cakeImg;
		this.backgroundColor = backgroundColor;
		this.pinkLetter = pinkLetter;
		this.engName = engName;
		this.korName = korName;
		this.subtitle = subtitle;
		this.price = price;
		this.oneTime = oneTime;
		this.kcal = kcal;
		this.fat = fat;
		this.sodium = sodium;
		this.sugar = sugar;
		this.protein = protein;
		this.allergy = allergy;
		this.infoImg = infoImg;
	}

	public String getCakeImg() {
		return cakeImg;
	}

	public void setCakeImg(String cakeImg) {
		this.cakeImg = cakeImg;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getPinkLetter() {
		return pinkLetter;
	}

	public void setPinkLetter(String pinkLetter) {
		this.pinkLetter = pinkLetter;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOneTime() {
		return oneTime;
	}

	public void setOneTime(int oneTime) {
		this.oneTime = oneTime;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getInfoImg() {
		return infoImg;
	}

	public void setInfoImg(String infoImg) {
		this.infoImg = infoImg;
	}

}
