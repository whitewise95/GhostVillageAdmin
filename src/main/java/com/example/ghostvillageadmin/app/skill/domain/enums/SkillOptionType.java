package com.example.ghostvillageadmin.app.skill.domain.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 스킬옵션타입
 */
public enum SkillOptionType {
	COOL_TIME("쿨타임"),
	DURATION("지속시간"),
	SCOPE("범위"),
	MANA_DOWN("마나 소모량"),
	EXP_COUNT("숙련도");

	private final String label;

	SkillOptionType(String label) {
		this.label = label;
	}

	public static List<EnumDto.Response> getList() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (SkillOptionType value : SkillOptionType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
