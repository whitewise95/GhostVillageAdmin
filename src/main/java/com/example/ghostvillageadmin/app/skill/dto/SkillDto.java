package com.example.ghostvillageadmin.app.skill.dto;

import com.example.ghostvillageadmin.app.skill.domain.enums.SkillElementType;
import com.example.ghostvillageadmin.app.skill.domain.enums.StatsType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class SkillDto {

	@Getter
	@Setter
	public static class Response {

		@Schema(description = "스킬 고유번호")
		private Long id;

		@Schema(description = "스킬명")
		private String name;

		@Schema(description = "스킬동적번호")
		private String dynamicId;

		@Schema(description = "스킬 이펙트 ID")
		private Integer effectId;

		@Schema(description = "스킬 등급")
		private Integer rank;

		@Schema(description = "코스트")
		private Integer coast;

		@Schema(description = "스킬 속성")
		private SkillElementType elementType;

		@Schema(description = "능력치 유형")
		private StatsType statsType;
	}

	@Getter
	@Setter
	public static class DetailResponse extends Response {

		@Schema(description = "첫 번째 속성 값")
		private Float value1;

		@Schema(description = "value1의 증가량")
		private Float value1Add;

		@Schema(description = "두 번째 속성 값")
		private Float value2;

		@Schema(description = "value2의 증가량")
		private Float value2Add;

		@Schema(description = "세 번째 속성 값")
		private Float value3;

		@Schema(description = "value3의 증가량")
		private Float value3Add;

		@Schema(description = "네 번째 속성 값")
		private Float value4;

		@Schema(description = "value4의 증가량")
		private Float value4Add;

		@Schema(description = "쿨탐임")
		private Float cool;

		@Schema(description = "쿨다운 감소량")
		private Float coolDec;

		@Schema(description = "지속 시간")
		private Float time;

		@Schema(description = "지속 시간 증가량")
		private Float timeAdd;

		@Schema(description = "범위")
		private Float size;

		@Schema(description = "범위 증가량")
		private Float sizeAdd;

		@Schema(description = "마나 소모량")
		private Float mana;

		@Schema(description = "마나 소모량 감소량")
		private Float manaDec;

		@Schema(description = "스킬 숙련도 증가 횟수")
		private Integer expCount;

		@Schema(description = "숙련도 증가량")
		private Integer expAdd;

	}

	@Getter
	@Setter
	public static class Create {

		@NotBlank(message = "스킬명을 입력해주세요.")
		@Schema(description = "스킬명")
		private String name;

		@NotNull(message = "스킬 이펙트 ID를 입력해주세요.")
		@Schema(description = "스킬 이펙트 ID")
		private Integer effectId;

		@NotNull(message = "스킬 동적 번호를 입력해주세요.")
		@Schema(description = "스킬 동적 번호")
		private Long dynamicId;

		@NotNull(message = "스킬등급을 입력해주세요.")
		@Schema(description = "스킬 등급")
		private Integer rank;

		@NotNull(message = "코스트 입력해주세요.")
		@Schema(description = "코스트")
		private Integer coast;

		@NotNull(message = "스킬 속성 입력해주세요.")
		@Schema(description = "스킬 속성")
		private SkillElementType elementType;

		@NotNull(message = "능력치 유형 입력해주세요.")
		@Schema(description = "능력치 유형")
		private StatsType statsType;

		@NotNull(message = "첫 번째 속성 값 입력해주세요.")
		@Schema(description = "첫 번째 속성 값")
		private Float value1;

		@NotNull(message = "value1의 증가량 입력해주세요.")
		@Schema(description = "value1의 증가량")
		private Float value1Add;

		@NotNull(message = "두 번째 속성 값 입력해주세요.")
		@Schema(description = "두 번째 속성 값")
		private Float value2;

		@NotNull(message = "value2의 증가량 입력해주세요.")
		@Schema(description = "value2의 증가량")
		private Float value2Add;

		@NotNull(message = "세 번째 속성 값 입력해주세요.")
		@Schema(description = "세 번째 속성 값")
		private Float value3;

		@NotNull(message = "value3의 증가량 입력해주세요.")
		@Schema(description = "value3의 증가량")
		private Float value3Add;

		@NotNull(message = "네 번째 속성 값 입력해주세요.")
		@Schema(description = "네 번째 속성 값")
		private Float value4;

		@NotNull(message = "value4의 증가량 입력해주세요.")
		@Schema(description = "value4의 증가량")
		private Float value4Add;

		@NotNull(message = "쿨타임 입력해주세요.")
		@Schema(description = "쿨타임")
		private Float cool;

		@NotNull(message = "쿨타임 감소량 입력해주세요.")
		@Schema(description = "쿨타임 감소량")
		private Float coolDec;

		@NotNull(message = "지속 시간 입력해주세요.")
		@Schema(description = "지속 시간")
		private Float time;

		@NotNull(message = "지속 시간 증가량 입력해주세요.")
		@Schema(description = "지속 시간 증가량")
		private Float timeAdd;

		@NotNull(message = "범위 입력해주세요.")
		@Schema(description = "범위")
		private Float size;

		@NotNull(message = "범위 증가량 입력해주세요.")
		@Schema(description = "범위 증가량")
		private Float sizeAdd;

		@NotNull(message = "마나 소모량 입력해주세요.")
		@Schema(description = "마나 소모량")
		private Float mana;

		@NotNull(message = "마나 소모량 감소량 입력해주세요.")
		@Schema(description = "마나 소모량 감소량")
		private Float manaDec;

		@NotNull(message = "스킬 숙련도 증가 횟수 입력해주세요.")
		@Schema(description = "스킬 숙련도 증가 횟수")
		private Integer expCount;

		@NotNull(message = "숙련도 증가량 입력해주세요.")
		@Schema(description = "숙련도 증가량")
		private Integer expAdd;

	}

	@Getter
	@Setter
	public static class Update extends Create {

	}
}
