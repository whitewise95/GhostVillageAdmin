package com.example.ghostvillageadmin.app.equipment.entity;

import com.example.ghostvillageadmin.app.equipment.entity.enums.*;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.HashSet;
import java.util.Set;

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
    @Enumerated(EnumType.STRING)
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

    /**
     * 속성 목록
     * */
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    private Set<EquipmentElement> equipmentElementList = new HashSet<>();

    /**
     * 스탯 목록
     * */
    @OrderBy("id asc")
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EquipmentStat> equipmentStatList = new HashSet<>();
}
