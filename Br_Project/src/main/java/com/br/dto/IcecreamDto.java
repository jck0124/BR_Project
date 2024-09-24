package com.br.dto;

public class IcecreamDto {
	private int icecreamIdx;
	private String nameKor;
	private String nameEng;
	private String imgUrl;
	private String detailImg;
	private String info;
	private String hashtag;
	private String backgroundColor; 
	private String textColor;
	
	public IcecreamDto() {
	
	}
	
	public IcecreamDto(int icecreamIdx, String nameKor, String nameEng, String imgUrl, String detailImg, String info,
			String hashtag, String backgroundColor, String textColor) {
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
}
