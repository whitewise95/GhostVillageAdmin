package com.example.ghostvillageadmin.app.skill.domain.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 속성타입
 */
public enum ElementType {
	FIRE("불", 1),
	WATER("물", 2),
	ELECTRIC("전기", 3),
	LAND("땅", 4);

	private final String label;
	private final Integer sort;

	ElementType(String label, Integer sort) {
		this.label = label;
		this.sort = sort;
	}

	public static List<EnumDto.Response> getList() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (ElementType value : ElementType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
