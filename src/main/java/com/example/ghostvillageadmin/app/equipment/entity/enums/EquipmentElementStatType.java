package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 장비 속성 능력치타입
 */
public enum EquipmentElementStatType {
    ATK("데미지", 1),
    CON("지속시간", 2),
    SCA("범위", 3);

    private String label;
    private Integer sort;

    EquipmentElementStatType(String label, Integer sort) {
        this.label = label;
        this.sort = sort;
    }

    public static List<EnumDto.Response> getList() {
        List<EnumDto.Response> Response = new ArrayList<>();
        for (EquipmentElementStatType value : EquipmentElementStatType.values()) {
            Response.add(new EnumDto.Response(value.label, value.name()));
        }
        return Response;
    }
}
