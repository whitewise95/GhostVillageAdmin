package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.domain.enums.SkillElementType;
import com.example.ghostvillageadmin.app.skill.dto.EnumDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 장비 속성타입
 * */
public enum EquipmentElementType {
    FIRE("불", 1),
    WATER("물", 2),
    ELECTRIC("전기", 3),
    LAND("땅", 4),
    EXTRA("미포함", 5),
    ALL("전체", 6);

    private final String label;
    private final Integer sort;

    EquipmentElementType(String label, Integer sort) {
        this.label = label;
        this.sort = sort;
    }

    public static List<EnumDto.Response> getList() {
        List<EnumDto.Response> Response = new ArrayList<>();
        for (EquipmentElementType value : EquipmentElementType.values()) {
            Response.add(new EnumDto.Response(value.label, value.name()));
        }
        return Response;
    }
}
