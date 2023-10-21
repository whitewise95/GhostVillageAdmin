package com.example.ghostvillageadmin.app.equipment.controller;

import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDto;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EnforceLastType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementStatType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentRankType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.StatType;
import com.example.ghostvillageadmin.app.equipment.service.EquipmentService;
import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import com.example.ghostvillageadmin.app.utils.PagableDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class EquipmentController {

	private final EquipmentService equipmentService;

	@Operation(summary = "장비 목록 view", hidden = true)
	@GetMapping("/view/equipment")
	public ModelAndView viewEquipment(ModelAndView modelAndView,
									  PagableDto.Request request) {
		modelAndView.setViewName("equipment/equipment");
		modelAndView.addObject("pageable", equipmentService.getEquipmentList(request));
		return modelAndView;
	}

	@Operation(summary = "장비 상세 view", hidden = true)
	@GetMapping("/view/equipment/detail/{id}")
	public ModelAndView viewEquipment(ModelAndView modelAndView,
									  @PathVariable Long id) {
		modelAndView.setViewName("equipment/detail");
		modelAndView.addObject("equipment", equipmentService.getEquipment(id));
		modelAndView.addObject("enforceLastType", EnforceLastType.getList());
		modelAndView.addObject("equipmentElementStatType", EquipmentElementStatType.getList());
		modelAndView.addObject("equipmentElementType", EquipmentElementType.getList());
		modelAndView.addObject("equipmentRankType", EquipmentRankType.getList());
		modelAndView.addObject("statType", StatType.getList());
		return modelAndView;
	}

	@Operation(summary = "장비 create view", hidden = true)
	@GetMapping("/view/equipment/create")
	public String viewCreate(Model model) {
		model.addAttribute("enforceLastType", EnforceLastType.getList());
		model.addAttribute("equipmentElementStatType", EquipmentElementStatType.getList());
		model.addAttribute("equipmentElementType", EquipmentElementType.getList());
		model.addAttribute("equipmentRankType", EquipmentRankType.getList());
		model.addAttribute("statType", StatType.getList());
		return "equipment/create";
	}

	@ResponseBody
	@Operation(summary = "장비 능력치 타입 목록 조회")
	@GetMapping("/api/equipment/stat-type")
	public ResponseEntity<List<EnumDto.Response>> getStatTypeList() {
		return ResponseEntity.ok(StatType.getList());
	}

	@ResponseBody
	@Operation(summary = "장비 속성타입 목록들 조회")
	@GetMapping("/api/equipment/element-types")
	public ResponseEntity<Map<String, List<EnumDto.Response>>> getElementTypesMap() {
		Map<String, List<EnumDto.Response>> responseMap = new HashMap<>();
		responseMap.put("equipmentElementType", EquipmentElementType.getList());
		responseMap.put("equipmentElementStatType", EquipmentElementStatType.getList());
		return ResponseEntity.ok(responseMap);
	}

	@ResponseBody
	@Operation(summary = "장비등록")
	@PostMapping("/api/equipment")
	public void create(@RequestBody @Valid EquipmentDto.Create create) {
		equipmentService.create(create);
	}

	@ResponseBody
	@Operation(summary = "장비수정")
	@PutMapping("/api/equipment/{id}")
	public void update(@PathVariable Long id,
					   @RequestBody @Valid EquipmentDto.Update update) {
		equipmentService.update(id, update);
	}

	@ResponseBody
	@Operation(summary = "장비삭제")
	@DeleteMapping("/api/equipment/{id}")
	public void delete(@PathVariable Long id) {
		equipmentService.delete(id);
	}
}
