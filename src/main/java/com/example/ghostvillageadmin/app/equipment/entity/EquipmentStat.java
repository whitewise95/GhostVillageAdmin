package com.example.ghostvillageadmin.app.equipment.entity;

import com.example.ghostvillageadmin.app.equipment.entity.enums.StatType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * 장비 능력치
 */
@Getter
@Setter
@Entity
public class EquipmentStat extends BaseDomainWithId {

    @NotNull
    @Comment("능력치 타입")
    private StatType statType;

    @NotNull
    @Comment("능력치")
    private Float stat;

    @NotNull
    @Comment("능력치증가폭")
    private Float statIncrease;

    @NotNull
    @Comment("장비 고유 번호")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Equipment equipment;
}
