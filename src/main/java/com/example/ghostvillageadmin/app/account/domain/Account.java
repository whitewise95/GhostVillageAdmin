package com.example.ghostvillageadmin.app.account.domain;

import com.example.ghostvillageadmin.app.account.enums.AccountType;
import com.example.ghostvillageadmin.base.BaseDomainWithId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 계정
 */
@Getter
@Setter
@Entity
public class Account extends BaseDomainWithId {

	/**
	 * 계정타입
	 */
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	/**
	 * 최종로그인시간
	 */
	private LocalDateTime lastLoginAt;

	/**
	 * 최종로그인IP
	 */
	private String lastLoginIp;

	public Account() {
	}

	/**
	 * 계정 생성
	 */
	public static Account createAccount(AccountType accountType) {
		Account account = new Account();
		account.setAccountType(accountType);
		return account;
	}
}
