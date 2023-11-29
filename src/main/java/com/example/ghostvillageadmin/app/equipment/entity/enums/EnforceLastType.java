package com.example.ghostvillageadmin.app.equipment.entity.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * 최종 강화 타입
 */
@Getter
public enum EnforceLastType {
	DAMAGE_DOWN_AND_PROJECTILE_DOUBLE("데미지감소 및 투사체 개수 2배", 1),
	SPEED_UP("이동속도 증가", 2),
	RESISTANCE_UP("방어력 증가", 3),
	TIME_STRETCH("(설치물 및 지속시간 1초 이상)지속시간 증가", 4),
	HEALING_UP("회복력 증가", 5),
	LUCKUP("(패시브 스킬 갯수 및 아이템 획득률)행운 증가", 6),
	MANA_UP("마나 사용량 감소", 7),
	COOL_DOWN("30초마다 모든 쿨타임 감소", 8),
	SKILL_SCOPE_UP("30초마다 한 번 스킬 범위 증가", 9),
	HEALTH_UP("체력 증가", 10),
	REVIVE_ONCE("1회 부활", 11),
	DEBUFF_TIME_UP("모든 디버프 지속시간 증가", 12);

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
