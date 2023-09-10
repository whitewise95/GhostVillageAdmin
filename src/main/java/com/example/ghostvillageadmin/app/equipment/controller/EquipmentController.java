package com.example.ghostvillageadmin.app.equipment.controller;

import com.example.ghostvillageadmin.app.equipment.entity.EquipmentStat;
import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import com.example.ghostvillageadmin.app.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping("/view/equipment")
    public String viewCreate(Model model) {
        model.addAttribute("enforceLastType", EnforceLastType.getList());
        model.addAttribute("equipmentElementStatType", EquipmentElementStatType.getList());
        model.addAttribute("equipmentElementType", EquipmentElementType.getList());
        model.addAttribute("equipmentRankType", EquipmentRankType.getList());
        model.addAttribute("statType", StatType.getList());
        return "equipment/create";
    }
}
