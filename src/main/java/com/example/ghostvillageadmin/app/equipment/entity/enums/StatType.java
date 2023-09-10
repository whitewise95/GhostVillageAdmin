package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 능력치 타입
 */
public enum StatType {
    ATK("공격력", 1),
    DEF("방어력", 2),
    SPD("스피드", 3),
    HP("생명력", 4),
    MP("마나", 5);

    private final String label;
    private final Integer sort;

    StatType(String label, Integer sort) {
        this.label = label;
        this.sort = sort;
    }

    public static List<EnumDto.Response> getList() {
        List<EnumDto.Response> Response = new ArrayList<>();
        for (StatType value : StatType.values()) {
            Response.add(new EnumDto.Response(value.name(), value.name()));
        }
        return Response;
    }
}
