package com.example.ghostvillageadmin.app.equipment.dto;

import com.example.ghostvillageadmin.app.equipment.entity.enums.EnforceLastType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementStatType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentRankType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.StatType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class EquipmentDto {

	@Getter
	@Setter
	public static class Response {

		@Schema(description = "장비 고유 번호")
		private Long id;

		@Schema(description = "장비 동적 번호")
		private Long dynamicId;

		@Schema(description = "장비명")
		private String name;

		@Schema(description = "등급")
		private EquipmentRankType rank_type;

		@Schema(description = "이미지아이디")
		private Integer image_id;

		@Schema(description = "최종 강화효과 타입")
		private EnforceLastType last_type;
	}

	@Getter
	@Setter
	public static class DetailResponse {

		@Schema(description = "장비 고유 번호")
		private Long id;

		@Schema(description = "장비명")
		private String name;

		@Schema(description = "장비 동적 번호")
		private Long dynamicId;

		@Schema(description = "등급")
		private EquipmentRankType rank_type;

		@Schema(description = "이미지고유번호")
		private Integer image_id;

		@Schema(description = "최종 강화효과 타입")
		private EnforceLastType last_type;

		@Schema(description = "촤종 강화효과 수치")
		private Float last;

		@Schema(description = "스탯목록")
		private List<StatsDetailResponse> statsList = new ArrayList<>();

		@Schema(description = "속성목록")
		private List<ElementDetailResponse> elementList = new ArrayList<>();
	}

	@Getter
	@Setter
	public static class StatsDetailResponse {

		@Schema(description = "스탯 고유번호")
		private Long id;

		@Schema(description = "능력치 타입")
		private StatType statType;

		@Schema(description = "능력치")
		private Float stat;

		@Schema(description = "능력치증가폭")
		private Float statAdd;
	}

	@Getter
	@Setter
	public static class ElementDetailResponse {

		@Schema(description = "속성 고유번호")
		private Long id;

		@Schema(description = "속성타입")
		private EquipmentElementType elementType;

		@Schema(description = "속성 능력치 타입")
		private EquipmentElementStatType elementStatType;

		@Schema(description = "속성수치")
		private Float value;

		@Schema(description = "속성수치 증가폭")
		private Float valueIncrease;

		@Schema(description = "속성내성")
		private Float resistValue;

		@Schema(description = "속성내성 증가폭")
		private Float resistValueIncrease;
	}

	@Getter
	@Setter
	public static class Create {

		@NotBlank(message = "장비명을 입력해주세요.")
		@Schema(description = "장비명")
		private String name;

		@NotNull(message = "등급을 선택해주세요.")
		@Schema(description = "등급")
		private EquipmentRankType rankType;

		@NotNull(message = "장비 동적 번호를 입력해주세요.")
		@Schema(description = "장비 동적 번호")
		private Long dynamicId;

		@NotNull(message = "이미지고유번호를 입력해주세요.")
		@Schema(description = "이미지고유번호")
		private Integer imageId;

		@Schema(description = "스탯목록")
		@NotEmpty(message = "최소 하나의 스탯은 존재해야합니다.")
		private List<@Valid CreateOrUpdateStats> statsList = new ArrayList<>();

		@Schema(description = "속성목록")
		@NotEmpty(message = "최소 하나의 속성은 존재해야합니다.")
		private List<@Valid CreateOrUpdateElement> elementList = new ArrayList<>();

		@NotNull(message = "최종 강화효과 타입을 선택해주세요.")
		@Schema(description = "최종 강화효과 타입")
		private EnforceLastType lastType;

		@NotNull(message = "촤종 강화효과 수치를 입력해주세요.")
		@Schema(description = "촤종 강화효과 수치")
		private Float last;
	}

	@Getter
	@Setter
	public static class CreateOrUpdateStats {

		@Schema(description = "고유번호 없으면 생성 있으면 업데이트")
		private Long id;

		@NotNull(message = "능력치 타입을 선택해주세요.")
		@Schema(description = "능력치 타입")
		private StatType statType;

		@NotNull(message = "능력치을 입력해주세요.")
		@Schema(description = "능력치")
		private Float stat;

		@NotNull(message = "능력치증가폭을 입력해주세요.")
		@Schema(description = "능력치증가폭")
		private Float statAdd;
	}

	@Getter
	@Setter
	public static class CreateOrUpdateElement {

		@Schema(description = "고유번호 없으면 생성 있으면 업데이트")
		private Long id;

		@NotNull(message = "속성타입을 선택해주세요.")
		@Schema(description = "속성타입")
		private EquipmentElementType elementType;

		@NotNull(message = "속성 능력치 타입 선택해주세요.")
		@Schema(description = "속성 능력치 타입")
		private EquipmentElementStatType elementStatType;

		@NotNull(message = "속성수치을 입력해주세요.")
		@Schema(description = "속성수치")
		private Float value;

		@NotNull(message = "속성수치 증가폭을 입력해주세요.")
		@Schema(description = "속성수치 증가폭")
		private Float valueIncrease;

		@NotNull(message = "속성내성을 입력해주세요.")
		@Schema(description = "속성내성")
		private Float resistValue;

		@NotNull(message = "속성내성 증가폭을 입력해주세요.")
		@Schema(description = "속성내성 증가폭")
		private Float resistValueIncrease;
	}

	@Getter
	@Setter
	public static class Update extends Create {

	}
}
