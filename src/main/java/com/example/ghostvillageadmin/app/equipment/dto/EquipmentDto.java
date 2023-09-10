package com.example.ghostvillageadmin.app.equipment.dto;

import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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

        @NotNull(message = "능력치 타입을 선택해주세요.")
        @Schema(description = "능력치 타입")
        private StatType statType;

        @NotNull(message = "능력치을 입력해주세요.")
        @Schema(description = "능력치")
        private Float stat;

        @NotNull(message = "능력치증가폭을 입력해주세요.")
        @Schema(description = "능력치증가폭")
        private Float statAdd;

        @NotNull(message = "마나를 입력해주세요.")
        @Schema(description = "마나")
        private Float mp;

        @NotNull(message = "마나 증가폭을 입력해주세요")
        @Schema(description = "마나 증가폭")
        private Float mpAdd;

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
        private Float valueAdd;

        @NotNull(message = "속성내성을 입력해주세요.")
        @Schema(description = "속성내성")
        private Float resist;

        @NotNull(message = "속성내성 증가폭을 입력해주세요.")
        @Schema(description = "속성내성 증가폭")
        private Float resistAdd;

        @NotNull(message = "최종 강화효과 타입을 선택해주세요.")
        @Schema(description = "최종 강화효과 타입")
        private EnforceLastType lastType;

        @NotNull(message = "촤종 강화효과 수치를 입력해주세요.")
        @Schema(description = "촤종 강화효과 수치")
        private Float last;
    }

    @Getter
    @Setter
    public static class Update extends Create {

    }
}
