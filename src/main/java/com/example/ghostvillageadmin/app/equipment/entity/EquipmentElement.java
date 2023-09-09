package com.example.ghostvillageadmin.app.equipment.entity;

import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementStatType;
import com.example.ghostvillageadmin.app.equipment.entity.enums.EquipmentElementType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * 장비속성
 */
@Getter
@Setter
@Entity
public class EquipmentElement extends BaseDomainWithId {

    @NotNull
    @Comment("속성타입")
    @Enumerated(EnumType.STRING)
    private EquipmentElementType elementType;

    @NotNull
    @Comment("속성 능력치 타입")
    @Enumerated(EnumType.STRING)
    private EquipmentElementStatType elementStatType;

    @NotNull
    @Comment("속성수치")
    private Float value;

    @NotNull
    @Comment("속성수치 증가폭")
    private Float valueIncrease;

    @NotNull
    @Comment("속성내성")
    private Float resistVale;

    @NotNull
    @Comment("속성내성 증가폭")
    private Float resistValeIncrease;

    @NotNull
    @Comment("장비 고유 번호")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Equipment equipment;
}
