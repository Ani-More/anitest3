package com.kh.anitest3.domain.business.dto;

public class BcategoryDTO {
  /**
   * 업체카테고리
   * BCATEGORY 테이블 (업체카테고리)
   */
  private String bnum;					// bnum 추가
  private String bhospital; 		// char(1) DEFAULT 'N' not null check(bhospital = 'Y' or bhospital ='N'),
  private String bpharmacy; 		// char(1) DEFAULT 'N' not null check(bpharmacy = 'Y' or bpharmacy ='N'),
  private String bhotel; 				// char(1) DEFAULT 'N' not null check(bhotel = 'Y' or bhotel ='N'),
  private String bkindergarden; // char(1) DEFAULT 'N' not null check(bkindergarden = 'Y' or bkindergarden ='N'),
  private String bfood; 				// char(1) DEFAULT 'N' not null check(bfood = 'Y' or bfood ='N'),
  private String btraining; 		// char(1) DEFAULT 'N' not null check(btraining = 'Y' or btraining ='N'),
  private String bshop; 				// char(1) DEFAULT 'N' not null check(bshop = 'Y' or bshop ='N'),
  private String bplayground; 	// char(1) DEFAULT 'N' not null check(bplayground = 'Y' or bplayground ='N'),
  private String bhairshop; 		// char(1) DEFAULT 'N' not null check(bhairshop = 'Y' or bhairshop ='N'),
	private String betc; 					// char(1) DEFAULT 'N' not null check(betc = 'Y' or betc ='N'),
}
