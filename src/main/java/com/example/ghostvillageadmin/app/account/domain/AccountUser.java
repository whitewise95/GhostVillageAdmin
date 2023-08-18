package com.example.ghostvillageadmin.app.account.domain;

import com.example.ghostvillageadmin.base.BaseDomainAccount;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@Entity
public class AccountUser extends BaseDomainAccount implements Persistable<Account> {

	/**
	 * 계정마스터 고유번호
	 */
	@Id
	@Column(name = "account_id")
	private Long id;

	/**
	 * 계정마스터
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(unique = true)
	@MapsId //@MapsId 는 @id로 지정한 컬럼에 @OneToOne 이나 @ManyToOne 관계를 매핑시키는 역할
	private Account account;

	/**
	 * 고유키
	 */
	@NotNull
	@Column(unique = true)
	private String uid;

	/**
	 * 닉네임
	 */
	@Column(unique = true)
	private String nickName;

	/**
	 * 에너지
	 */
	@NotNull
	@ColumnDefault("30")
	private Integer energy = 30;

	/**
	 * 에너지 마지막 시간계산 시간
	 */
	private LocalDateTime lastEnergyAt;

	/**
	 * 게임머니
	 */
	@NotNull
	@ColumnDefault("1000")
	private Integer gameMoney = 1000;

	/**
	 * 현금
	 */
	@NotNull
	@ColumnDefault("100")
	private Integer realMoney = 100;

	/**
	 * 마지막 스테이지
	 */
	@NotNull
	@ColumnDefault("1")
	private Integer lastStage = 1;

	@Override
	public boolean isNew() {
		return account == null;
	}

	@Override
	public Account getId() {
		return this.account;
	}

	// TODO 가차
}
