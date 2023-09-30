package com.example.ghostvillageadmin.app.equipment.controller;

import com.example.ghostvillageadmin.app.equipment.dto.EquipmentDto;
import com.example.ghostvillageadmin.app.equipment.entity.EquipmentStat;
import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import com.example.ghostvillageadmin.app.equipment.service.EquipmentService;
import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Operation(summary = "장비 create view", hidden = true)
    @GetMapping("/view/equipment")
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
        System.out.println("sadasd");

    }
}
