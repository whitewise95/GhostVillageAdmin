package com.example.ghostvillageadmin.app.gacha.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;

public enum GachaUseMoneyType {

	GOLD("골드 ", 1),

	DIAMOND("다이아", 2);

	private String label;
	private Integer sort;

	GachaUseMoneyType(String label, Integer sort) {
		this.label = label;
		this.sort = sort;
	}

	public static List<EnumDto.Response> GachaUseMoneyType() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (GachaUseMoneyType value : GachaUseMoneyType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
