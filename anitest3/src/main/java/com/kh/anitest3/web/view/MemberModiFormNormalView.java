package com.kh.anitest3.web.view;

import org.springframework.web.multipart.MultipartFile;

public class MemberModiFormNormalView {
	/**
	 * 회원 (공통정보)
	 * MEMBER 테이블
	 */
  private String id; 				//  varchar2(40),
  private String pw;				//  varchar2 (16) not null,
  private String pw2;
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
   * MYANI 테이블 (키우는 동물)
   */
  			//mnum (동물번호)
  			//mid (사용자 아이디)
  private String animal; 		// varchar(30),
}
