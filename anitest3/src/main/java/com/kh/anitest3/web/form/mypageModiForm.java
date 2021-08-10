package com.kh.anitest3.web.form;

import org.springframework.web.multipart.MultipartFile;

public class MyPageModiForm {
	/**
	 * 회원 (공통정보)
	 * MEMBER 테이블
	 */
  private String id; 				//  varchar2(40),
  private String pw;				//  varchar2 (16) not null,
  private String pw2;	//비밀번호변경용
  private String pw3;	//비밀번호변경확인용
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
//  private String fsize; 		//  varchar2(45),
//  private String ftype; 		//  varchar2(50),
//  private String fname; 		//  varchar2(150),
//  private Integer mileage; 	//  number(6) DEFAULT 0 not null ,
  
  private MultipartFile profileImage; //프로필사진
  
  /**
   * 키우는동물
   * 일반회원
   * MYANI 테이블 (키우는 동물)
   */
  			//mnum (동물번호)
  			//mid (사용자 아이디)
  private String animal; 		// varchar(30),
  
  /**
   * 자격증정보
   * 특수회원
   * PROFESSION 테이블 (전문가)
   */
  			//pnum 전문가번호
  			//pid 아이디(사용자아이디)
  private String licenseno; // varchar2(20) not null,
  
}
