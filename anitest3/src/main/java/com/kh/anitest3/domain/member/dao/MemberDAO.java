package com.kh.anitest3.domain.member.dao;

import java.util.List;

import com.kh.anitest3.domain.member.dto.MemberDTO_old;
import com.kh.anitest3.web.form.JoinNormalForm;
import com.kh.anitest3.web.form.JoinSpecialForm;

public interface MemberDAO {
	
	//회원가입
	void join(MemberDTO_old memberDTO);		//임시
	void join(JoinNormalForm joinNF);
	void join(JoinSpecialForm joinSF);
	
	//회원조회 by ID
	MemberDTO_old findByID(String id);
	
	//회원수정 by ID
	void update(String id,MemberDTO_old memberDTO);
	
	//회원탈퇴 by ID
	void out(String id);
	
	//회원목록 
	List<MemberDTO_old> list();
	
	//로그인
	MemberDTO_old findByIdPw(String id,String pw);
	
	//아이디찾기
	String findId(String tel, String birth);
	
	//비밀번호찾기
	String findPw(String id, String tel, String birth);
}
