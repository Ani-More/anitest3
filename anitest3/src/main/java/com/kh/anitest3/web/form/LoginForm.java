package com.kh.anitest3.web.form;

import lombok.Data;

@Data
public class LoginForm {
	private String id;
	private String pw;
	//자동로그인 체크여부 추가해야될듯
}