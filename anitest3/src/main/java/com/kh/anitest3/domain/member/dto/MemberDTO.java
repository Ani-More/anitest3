package com.kh.anitest3.domain.member.dto;

import lombok.Data;

/**
 * 임시로 사용
 * @author mypc
 *
 */
@Data
public class MemberDTO {
	
	/**
	 * 회원 (공통정보)
	 * MEMBER 테이블
	 */
  private String id; 				//  varchar2(40),
  private String pw;				//  varchar2 (16) not null,
  private String tel; 			//  varchar2(13) not null,
  private String email; 		//  varchar2(30) not null,
  private String name; 			//  varchar2(30) not null,
  private String nickname; 	//  varchar2(30) not null,
  private String gender; 		//  char(3) not null,
  private String address; 	//  varchar2(150) not null,
  private String birth; 		//  date not null,
  private String mtype; 		//  varchar2(1) not null check(mtype='N' or mtype='P' or mtype='B'),
//  cdate; 									//  timestamp DEFAULT systimestamp not null,
//  udate; 									//  timestamp DEFAULT systimestamp,
//  image; 									//  blob,
  private String fsize; 		//  varchar2(45),
  private String ftype; 		//  varchar2(50),
  private String fname; 		//  varchar2(150),
  private Integer mileage; 	//  number(6) DEFAULT 0 not null ,
  
  /**
   * 일반회원 전용 정보
   * MYANI 테이블 (키우는 동물)
   */
  			//mnum (동물번호)
  			//mid (사용자 아이디)
  private String animal; 		// varchar(30),
  
  /**
   * 전문가회원 전용 정보
   * PROFESSION 테이블 (전문가)
   */
  			//pnum 전문가번호
  			//pid 아이디(사용자아이디)
  private String licenseno; // varchar2(20) not null,
  
  /**
   * 사업자회원 전용 정보
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
  
  /**
   * 업체카테고리
   * BCATEGORY 테이블 (업체카테고리)
   */
  			// bnum 추가
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

	//임시로 사용
  private String bcategory;

}
