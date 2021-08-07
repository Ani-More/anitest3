package com.kh.anitest3.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {
	
	@NotBlank
	@Email
	private String id;
	@NotBlank
	private String pw;

	//자동로그인 체크여부 추가해야될듯
	private boolean autologincheck;
}
