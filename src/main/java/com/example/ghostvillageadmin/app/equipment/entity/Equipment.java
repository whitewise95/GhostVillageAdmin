package com.example.ghostvillageadmin.app.equipment.entity;

import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * 장비
 */
@Getter
@Setter
@Entity
public class Equipment extends BaseDomainWithId {

    @NotNull
    @Comment("장비명")
    private String name;

    @NotNull
    @Comment("등급")
    private EquipmentRankType rankType;

    @NotNull
    @Comment("이미지고유번호 외래키x")
    private Integer imageId;

    @NotNull
    @Comment("최종 강화효과 타입")
    @Enumerated(EnumType.STRING)
    private EnforceLastType enforceLastType;

    @NotNull
    @Comment("촤종 강화효과 수치")
    private Float enforceLastValue;
}
