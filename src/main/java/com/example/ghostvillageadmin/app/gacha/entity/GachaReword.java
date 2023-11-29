package com.example.ghostvillageadmin.app.gacha.entity;

import com.example.ghostvillageadmin.app.equipment.entity.Equipment;
import com.example.ghostvillageadmin.app.skill.domain.Skill;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * 가챠 리워드 관리
 * */
@Getter
@Setter
@Entity
public class GachaReword extends BaseDomainWithId {

	@NotNull
	@Comment("가차 마스터")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	private GachaMaster gachaMaster;

	@Comment("스킬 고유 번호")
	@ManyToOne(fetch = FetchType.LAZY)
	private Skill skill;

	@Comment("장비 고유 번호")
	@ManyToOne(fetch = FetchType.LAZY)
	private Equipment equipment;

	@Comment("확률")
	@NotNull
	private Integer percent;
}
