package com.example.ghostvillageadmin.app.skill.domain;

import com.example.ghostvillageadmin.app.skill.domain.enums.SkillOptionType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

/**
 * 스킬 옵션
 */
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkillOption extends BaseDomainWithId {

	@NotNull
	@Comment("옵션값")
	@ColumnDefault("0")
	private Float optionValue;

	@NotNull
	@Comment("증감폭")
	@ColumnDefault("0")
	private Float updateValue;

	@NotNull
	@Comment("스킬옵션타입")
	private SkillOptionType type;

	@NotNull
	@Comment("스킬")
	@ManyToOne(fetch = FetchType.LAZY)
	private Skill skill;

	public static SkillOption creeateSkillOption(Float optionValue, Float updateValue, SkillOptionType type, Skill skill) {
		SkillOption skillOption = new SkillOption();
		skillOption.setSkill(skill);
		skillOption.setType(type);
		skillOption.setOptionValue(optionValue);
		skillOption.setUpdateValue(updateValue);
		return skillOption;
	}
}
