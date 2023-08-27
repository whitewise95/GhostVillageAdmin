package com.example.ghostvillageadmin.app.skill.controller;

import com.example.ghostvillageadmin.app.skill.domain.enums.ElementType;
import com.example.ghostvillageadmin.app.skill.domain.enums.StatsType;
import com.example.ghostvillageadmin.app.skill.dto.SkillDto;
import com.example.ghostvillageadmin.app.skill.service.SkillService;
import com.example.ghostvillageadmin.app.utils.PagableDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class SkillController {

	private final SkillService skillService;

	@Operation(summary = "스킬 view", hidden = true)
	@GetMapping("/view/skill")
	public ModelAndView viewSkill(ModelAndView modelAndView,
								  PagableDto.Request request) {
		modelAndView.setViewName("/skill/skill");
		modelAndView.addObject("pageable", skillService.getSkillList(request));
		return modelAndView;
	}

	@Operation(summary = "스킬 create view", hidden = true)
	@GetMapping("/view/skill/create")
	public ModelAndView viewSkillCreate(ModelAndView modelAndView) {
		modelAndView.setViewName("skill/create");
		modelAndView.addObject("elementType", ElementType.getList());
		modelAndView.addObject("statsType", StatsType.getList());
		return modelAndView;
	}

	@Operation(summary = "스킬 detail view", hidden = true)
	@GetMapping("/view/skill/detail/{id}")
	public ModelAndView viewSkillDetail(ModelAndView modelAndView,
										@PathVariable Long id) {
		modelAndView.setViewName("skill/detail");
		modelAndView.addObject("skill", skillService.getSkill(id));
		modelAndView.addObject("elementType", ElementType.getList());
		modelAndView.addObject("statsType", StatsType.getList());
		return modelAndView;
	}

	@ResponseBody
	@Operation(summary = "스킬 생성")
	@PostMapping("/api/skill")
	public void create(@RequestBody @Valid SkillDto.Create create) {
		skillService.create(create);
	}

	@ResponseBody
	@Operation(summary = "스킬 수정")
	@PutMapping("/api/skill/{id}")
	public void update(@RequestBody @Valid SkillDto.Update update,
					   @PathVariable Long id) {
		skillService.update(update, id);
	}

	@ResponseBody
	@Operation(summary = "스킬 수정")
	@DeleteMapping("/api/skill/{id}")
	public void delete(@PathVariable Long id) {
		skillService.delete(id);
	}
}
