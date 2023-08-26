package com.example.ghostvillageadmin.app.skill.domain;

import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * 스킬 능력치
 */
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkillStats extends BaseDomainWithId {

	@NotNull
	@Comment("능력치 값")
	private Float statsValue;

	@NotNull
	@Comment("증감폭")
	private Float updateValue;

	@NotNull
	@Comment("정렬 순서")
	private Integer sortNum;

	@NotNull
	@Comment("스킬")
	@ManyToOne(fetch = FetchType.LAZY)
	private Skill skill;

	public static SkillStats createSkillStats(Float statsValue, Float updateValue, Integer sortNum, Skill skill) {
		SkillStats skillStats = new SkillStats();
		skillStats.setSkill(skill);
		skillStats.setStatsValue(statsValue);
		skillStats.setSortNum(sortNum);
		skillStats.setUpdateValue(updateValue);
		return skillStats;
	}
}
