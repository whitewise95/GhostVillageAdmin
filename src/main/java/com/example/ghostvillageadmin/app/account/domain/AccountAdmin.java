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
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.domain.Persistable;

/**
 * 관리자계정
 */
@Getter
@Setter
@Entity
public class AccountAdmin extends BaseDomainAccount implements Persistable<Account> {

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
	private String signName;

	/**
	 * 이름
	 */
	@NotNull
	private String name;

	/**
	 * 비밀번호
	 */
	@NotNull
	private String password;

	/**
	 * 승인여부
	 * */
	@NotNull
	@ColumnDefault("false")
	private Boolean isApproval;

	@Override
	public boolean isNew() {
		return false;
	}

	@Override
	public Account getId() {
		return account;
	}

	/**
	 * AccountId
	 */
	public Long getRawAccountId() {
		return account == null ? null : account.getId();
	}
}
