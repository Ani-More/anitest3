package com.kh.anitest3.domain.member.dto;

import lombok.Data;

@Data
public class MyaniDTO {
	/**
   * 일반회원 전용 정보
   * MYANI 테이블 (키우는 동물)
   */
  private String mnum;			//mnum (동물번호)
  private String mid;       //mid (사용자 아이디)
  private String animal; 		// varchar(30),
}
