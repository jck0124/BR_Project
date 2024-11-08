package com.br.dto;

// 카카오페이 요청 정보
public class KakaoPayReadyDto {
	
    private String tid;	// 결제 고유번호
    private String next_redirect_pc_url; // 결제 요청 메시지(TMS) 전송을 위한 Redirect URL (카카오 측 제공)
    
	public KakaoPayReadyDto() {
		
	}
	
	public KakaoPayReadyDto(String tid, String next_redirect_pc_url) {
		super();
		this.tid = tid;
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	
	public String getTid() {
		return tid;
	}
	
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
    
}
