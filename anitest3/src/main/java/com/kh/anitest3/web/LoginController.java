package com.kh.anitest3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	/**
	 * 로그인폼
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginProcess() {
		
		return "/index";
	}
}