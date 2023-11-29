package com.example.ghostvillageadmin.app.gacha.entity;

import com.example.ghostvillageadmin.app.gacha.entity.enums.GachaRewardType;
import com.example.ghostvillageadmin.app.gacha.entity.enums.GachaType;
import com.example.ghostvillageadmin.app.gacha.entity.enums.GachaUseMoneyType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

/**
 * 가챠 관리
 */
@Getter
@Setter
@Entity
public class GachaMaster extends BaseDomainWithId {

	@NotNull
	@Column(unique = true)
	@Comment("장비 동적 아이디 (외래키x)")
	private Long dynamicId;

	@NotNull
	@Comment("필요 재화량")
	@ColumnDefault("0")
	private Integer money = 0;

	@NotNull
	@Comment("가챠 타입(가챠시트)")
	private GachaType gachaType;

	@NotNull
	@Comment("보상")
	private GachaRewardType gachaRewardType;

	@NotNull
	@Comment("사용 재화")
	private GachaUseMoneyType gachaUseMoneyType;

	/**
	 * 가차 보상 목록
	 */
	@OneToMany(mappedBy = "gachaMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<GachaReword> gachaRewordList = new HashSet<>();
}
