package com.example.ghostvillageadmin.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HomeController {

	@GetMapping("/cms")
	public String home() {
		return "/home";
	}
}
