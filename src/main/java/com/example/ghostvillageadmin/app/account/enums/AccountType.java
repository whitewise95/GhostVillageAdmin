package com.example.ghostvillageadmin.app.account.enums;

/**
 * 계정타입
 */
public enum AccountType {
    ADMIN("관리자"),
    USER("사용자");

    public final String label;

    AccountType(String label) {
        this.label = label;
    }
}
