package com.example.ghostvillageadmin.app.skill.domain.enums;

import com.example.ghostvillageadmin.app.skill.dto.EnumDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 능력치 타입
 */
public enum StatsType {
	DAMAGE(1, "데미지"),
	PASS_DAMAGE(2, "방어 관통"),
	DAMAGE_AND_PASS_DAMAGE(3, "데미지 & 방어 관통"),
	TRUE_DAMAGE(4, "고정뎀"),
	SHIELD(5, "쉴드"),
	CURE(6, "회복"),
	INSTALL(7, "설치"),
	DAMAGE_AND_INSTALL(8, "데미지 & 설치"),
	FAST(9, "이동 속도 증가"),
	DAMAGE_AND_FAST(10, "데미지 & 이속증가"),
	CURE_UP(11, "체력 회복 속도 증가"),
	DAMAGE_AND_CURE_UP(12, "데미지 & 체력 회복 속도 증가"),
	DAMAGE_UP(13, "공격력 증가"),
	DEFENSE_UP(14, "방어력 증가"),
	DAMAGE_AND_DEFENSE_UP(15, "데미지 & 방어력 증가"),
	COOL_DOWN_UP(16, "쿨타임 감소"),
	DURATION_UP(17, "지속 시간 증가"),
	RANGE_UP(18, "범위 증가"),
	DAMAGE_UP_AND_RANGE_UP(19, "데미지 증가 & 범위 증가"),
	MANA_RECOVERY_UP(20, "마나 회복 속도 증가"),
	COOL_DOWN_UP_AND_MANA_RECOVERY_UP(21, "쿨타임 감소 & 마나 회복 속도 증가"),
	FAST_AND_CURE_UP_AND_MANA_RECOVERY_UP(22, "이속 증가 & 체력 회복 속도 증가"),
	SLOW(23, "감속"),
	DAMAGE_AND_SLOW(24, "데미지 & 이속 감소"),
	DEFENSE_DOWN(25, "방깍"),
	CROWD_CONTROL(26, "제압 디버프"),
	DAMAGE_AND_CROWD_CONTROL(27, "데미지 & 제압");

	private final int sort;
	private final String label;

	StatsType(int sort, String label) {
		this.sort = sort;
		this.label = label;
	}

	public static List<EnumDto.Response> getList() {
		List<EnumDto.Response> Response = new ArrayList<>();
		for (StatsType value : StatsType.values()) {
			Response.add(new EnumDto.Response(value.label, value.name()));
		}
		return Response;
	}
}
