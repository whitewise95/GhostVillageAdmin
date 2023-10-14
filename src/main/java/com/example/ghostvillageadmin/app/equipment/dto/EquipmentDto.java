package com.example.ghostvillageadmin.app.equipment.dto;

import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDto {

    @Getter
    @Setter
    public static class Response {
        @Schema(description = "장비 고유 번호")
        private Long id;

        @Schema(description = "장비명")
        private String name;

        @Schema(description = "등급")
        private EquipmentRankType rank_type;

        @Schema(description = "능력치 타입")
        private StatType stat_type;

        @Schema(description = "속성타입")
        private EquipmentElementType element_type;

        @Schema(description = "속성 능력치 타입")
        private EquipmentElementStatType element_stat_type;

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

        @Schema(description = "등급")
        private EquipmentRankType rank_type;

        @Schema(description = "이미지고유번호")
        private Integer image_id;

        @Schema(description = "능력치 타입")
        private StatType stat_type;

        @Schema(description = "능력치")
        private Float stat;

        @Schema(description = "능력치증가폭")
        private Float stat_add;

        @Schema(description = "마나")
        private Float mp;

        @Schema(description = "마나 증가폭")
        private Float mp_add;

        @Schema(description = "속성타입")
        private EquipmentElementType element_type;

        @Schema(description = "속성 능력치 타입")
        private EquipmentElementStatType element_stat_type;

        @Schema(description = "속성수치")
        private Float value;

        @Schema(description = "속성수치 증가폭")
        private Float value_add;

        @Schema(description = "속성내성")
        private Float resist;

        @Schema(description = "속성내성 증가폭")
        private Float resist_add;

        @Schema(description = "최종 강화효과 타입")
        private EnforceLastType last_type;

        @Schema(description = "촤종 강화효과 수치")
        private Float last;
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

        @NotNull(message = "이미지고유번호를 입력해주세요.")
        @Schema(description = "이미지고유번호")
        private Integer imageId;

        @Schema(description = "스탯목록")
        @NotEmpty(message = "최소 하나의 스탯은 존재해야합니다.")
        private List<@Valid CreateStats> statsList = new ArrayList<>();

        @Schema(description = "속성목록")
        @NotEmpty(message = "최소 하나의 속성은 존재해야합니다.")
        private List<@Valid CreateElement> elementList = new ArrayList<>();

        @NotNull(message = "최종 강화효과 타입을 선택해주세요.")
        @Schema(description = "최종 강화효과 타입")
        private EnforceLastType lastType;

        @NotNull(message = "촤종 강화효과 수치를 입력해주세요.")
        @Schema(description = "촤종 강화효과 수치")
        private Float last;
    }

    @Getter
    @Setter
    public static class CreateStats {
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
    public static class CreateElement {
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
