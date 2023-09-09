package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 최종 강화 타입
 */
public enum EnforceLastType {
    DAMAGE_DOWN_AND_PROJECTILE_DOUBLE("데미지감소 및 투사체 개수 2배", 1);

    private String label;
    private Integer sort;

    EnforceLastType(String label, Integer sort) {
        this.label = label;
        this.sort = sort;
    }

    public static List<EnumDto.Response> getList() {
        List<EnumDto.Response> Response = new ArrayList<>();
        for (EnforceLastType value : EnforceLastType.values()) {
            Response.add(new EnumDto.Response(value.label, value.name()));
        }
        return Response;
    }
}
