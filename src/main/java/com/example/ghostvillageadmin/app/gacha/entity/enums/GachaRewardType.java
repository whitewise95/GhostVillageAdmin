package com.example.ghostvillageadmin.app.gacha.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;

public enum GachaRewardType {
	EQUIPMENT("장비", 1),
	SKILL("스킬조각", 2);

	private String label;
	private Integer sort;

	GachaRewardType(String label, Integer sort) {
		this.label = label;
		this.sort = sort;
	}

	public static List<EnumDto.Response> getList() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (GachaRewardType value : GachaRewardType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
