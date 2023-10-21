package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * 장비 등급
 */
@Getter
public enum EquipmentRankType {
    NORMAL(1),
    RARE(2),
    UNIQUE(3),
    LEGEND(4),
    EPIC(5);

    private Integer sort;

    EquipmentRankType(Integer sort) {
        this.sort = sort;
    }

    public static List<EnumDto.Response> getList() {
        List<EnumDto.Response> Response = new ArrayList<>();
        for (EquipmentRankType value : EquipmentRankType.values()) {
            Response.add(new EnumDto.Response(value.name(), value.name()));
        }
        return Response;
    }
}
