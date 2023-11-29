package com.example.ghostvillageadmin.app.gacha.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public enum GachaType {
	GOLD_EQUIPMENT("골드 장비 가챠", 1),
	GOLD_SKILL("골드 스킬 가챠", 2),
	DIAMOND_EQUIPMENT("다이아 장비 가챠", 3),
	DIAMOND_SKILL("다이아 스킬 가챠", 4);

	private String label;
	private Integer sort;

	GachaType(String label, Integer sort) {
		this.label = label;
		this.sort = sort;
	}

	public static List<EnumDto.Response> getList() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (GachaType value : GachaType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
