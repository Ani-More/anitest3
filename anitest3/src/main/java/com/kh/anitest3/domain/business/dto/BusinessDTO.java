package com.kh.anitest3.domain.business.dto;

import lombok.Data;

@Data
public class BusinessDTO {
  /**
   * 사업자정보
   * BUSINESS 테이블 (업체)
   */
  			// id (bid)추가
  private String bnum;				// number(10)
  private String bbnum; 			// varchar2(20) not null,
  private String bname; 			// varchar2(30) not null,
  private String baddress; 		// varchar2 (150) not null,
  private String btell; 			// varchar2(13) not null,
  // 아래는 병원만 해당
  private String nightcare; 	// char(1) check(nightcare = 'Y' or nightcare ='N'),
  private String rareani; 		// char(1) check(rareani = 'Y' or rareani ='N'),
  private String visitcare; 	// char(1) check(visitcare = 'Y' or visitcare ='N'),
  private String holidayopen; // char(1) check(holidayopen = 'Y' or holidayopen ='N'),
  private String dental; 			// char(1) check(dental = 'Y' or dental ='N'),
}
