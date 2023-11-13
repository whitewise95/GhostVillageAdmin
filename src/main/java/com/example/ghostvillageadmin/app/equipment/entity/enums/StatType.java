package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * 능력치 타입
 */
@Getter
public enum StatType {
	NOT_TYPE("미포함", 0),
	ATK("공격력", 1),
	DEF("방어력", 2),
	SPD("스피드", 3),
	HP("생명력", 4),
	CURE_RE("체력회복속도", 5),
	MANA_RE("마나회복속도", 6),
	COOL_UP("쿨타임감소", 7),
	MP("마나", 8);

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
