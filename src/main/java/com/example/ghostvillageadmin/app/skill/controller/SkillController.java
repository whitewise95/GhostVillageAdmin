package com.example.ghostvillageadmin.app.skill.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {


	@Controller
	public static class SkillViewController {

		@Operation(summary = "스킬 view", hidden = true)
		@GetMapping("/view/skill")
		public String viewSkill() {
			return "/skill/skill";
		}
	}
}
