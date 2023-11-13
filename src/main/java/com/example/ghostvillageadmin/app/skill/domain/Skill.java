package com.example.ghostvillageadmin.app.skill.domain;

import com.example.ghostvillageadmin.app.skill.domain.enums.SkillElementType;
import com.example.ghostvillageadmin.app.skill.domain.enums.StatsType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * 스킬
 */
@Getter
@Setter
@Entity
public class Skill extends BaseDomainWithId {

	@NotNull
	@Comment("스킬명")
	private String name;

	@NotNull
	@Comment("이펙트 아이디 (외래키x)")
	private Integer effectId;

	@NotNull
	@Column(unique = true)
	@Comment("스킬 동적 아이디 (외래키x)")
	private Long dynamicId;

	@NotNull
	@Comment("스킬랭크")
	private Integer rank;

	@NotNull
	@Comment("코스트")
	private Integer coast;

	@Comment("속성타입")
	@NotNull
	@Enumerated(EnumType.STRING)
	private SkillElementType elementType;

	@Comment("능력치타입")
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatsType statsType;

	/**
	 * 스킬 옵션 목록
	 */
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SkillOption> skillOptionList = new HashSet<>();

	/**
	 * 스킬 능력치 목록
	 */
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SkillStats> skillStatsList = new HashSet<>();
}
