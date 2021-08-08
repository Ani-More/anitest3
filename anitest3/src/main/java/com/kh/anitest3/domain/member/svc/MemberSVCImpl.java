package com.kh.anitest3.domain.member.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.anitest3.domain.member.dao.MemberDAO;
import com.kh.anitest3.domain.member.dto.MemberDTO;
import com.kh.anitest3.web.form.JoinNormalForm;
import com.kh.anitest3.web.form.JoinSpecialForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC {

	private final MemberDAO memberDAO;
	
	/**
	 * 회원가입
	 * 서비스로직 작성 필요
	 */
	@Override
	public MemberDTO join(MemberDTO memberDTO) {
		memberDAO.join(memberDTO);
		return memberDTO;
	}
//	일반회원가입
	@Override
	public MemberDTO join(JoinNormalForm joinNF) {
		memberDAO.join(joinNF);
		return null;
	}
//	특수회원가입
	@Override
	public MemberDTO join(JoinSpecialForm joinSF) {
		memberDAO.join(joinSF);
		return null;
	}
	

	@Override
	public MemberDTO findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO update(String id, MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void out(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO findByIdPw(String id, String pw) {
		
		return memberDAO.findByIdPw(id,pw);
	}

	@Override
	public String findId(String tel, String birth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPw(String id, String tel, String birth) {
		// TODO Auto-generated method stub
		return null;
	}



}
