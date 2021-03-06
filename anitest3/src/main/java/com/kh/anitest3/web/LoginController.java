package com.kh.anitest3.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.anitest3.domain.member.dto.MemberDTO_old;
import com.kh.anitest3.domain.member.svc.MemberSVC;
import com.kh.anitest3.web.form.LoginForm;
import com.kh.anitest3.web.form.LoginMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final MemberSVC memberSVC;
	
	/**
	 * 로그인폼
	 * @return
	 */
	@GetMapping("/login")
	public String loginForm(@ModelAttribute LoginForm loginForm) {
		return "/member/login";
	}
	
	/**
	 * 로그인처리
	 * @param loginForm
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute LoginForm loginForm,	
			BindingResult bindingResult,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		
		log.info("loginForm:{}", loginForm);
		
		MemberDTO_old memberDTO = memberSVC.findByIdPw(loginForm.getId(), loginForm.getPw());
		
		//회원정보가 없는경우
		if(memberDTO == null) {
			bindingResult.reject("loginChk", "아이디 또는 비밀번호가 잘못되었습니다");			
			return "/member/login";
		}
		
		//로그인 성공시
//		쿠키에 저장할 정보 담기 (아이디, 닉네임, 회원유형)
		LoginMember loginMember = new LoginMember(memberDTO.getId(),memberDTO.getNickname(),memberDTO.getMtype());
		//로긴성공
		HttpSession session =request.getSession(true);
		session.setAttribute("loginMember", loginMember);
		
		//자동로그인 체크했으면
		if(loginForm.isAutologincheck()) {
			Cookie cookie = new Cookie("loginCookie", session.getId());
			
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);	//7일
			
			response.addCookie(cookie);
		}
		
		return "redirect:/main";
	}
	
	/**
	 * 로그아웃
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			log.info("세션제거!");
			session.invalidate();
		}
		
		return "redirect:/";
	}
	
}
