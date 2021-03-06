package com.kh.anitest3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@GetMapping("/main")
	public String home() {
		return "/index";
	}
}
