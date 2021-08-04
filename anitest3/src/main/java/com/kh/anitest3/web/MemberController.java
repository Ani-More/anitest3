package com.kh.anitest3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.anitest3.domain.member.dto.MemberDTO;
import com.kh.anitest3.domain.member.svc.MemberSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private final MemberSVC memberSVC;
	
	/**
	 * 회원가입폼
	 * @return
	 */
	@GetMapping("/join")
	public String joinForm() {
		
		//회원유형 선택화면에서 회원유형값 받아서 조인폼으로 넘겨야됨.
		//조인폼에서 받은 회원유형 값으로 보여줄 항목, 안보여줄 항목 선택되도록
		
		return "/member/joinForm";
	}
	
	/**
	 * 회원가입처리
	 */
	@PostMapping("/join")
	public String join(MemberDTO memberDTO) {
		
		memberSVC.join(memberDTO);
//		처리하고 인덱스로
		return "redirect:/main";
	}

	/**
	 * 회원조회 by ID
	 */
	@GetMapping("/member/{id}")
	public String findByID(String id) {
		
		MemberDTO memberDTO = memberSVC.findByID(id);
		
		return "";
	}
	
	/**
	 * 회원수정 by ID
	 */
	@PatchMapping("/member/{id}")
	public String update(String id,MemberDTO memberDTO) {
		
		
		return "redirect:/";
	}

	/**
	 * 회원탈퇴 by ID
	 */
	@DeleteMapping("/member/{id}")
	public String out(String id) {
		
		return "redirect:/";
	}

	/**
	 * 회원목록
	 */
	@GetMapping("/member/list")
	public String list() {
		
		return "";
	}
	

//	//로그인
//	MemberDTO findByIdPw(String id,String pw);
//	
//	//아이디찾기
//	String findId(String tel, String birth);
//	
//	//비밀번호찾기
//	String findPw(String id, String tel, String birth);
	
	
}