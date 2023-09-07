package com.example.ghostvillageadmin.app.equipment.entity.enums;

/**
 * 능력치 타입
 */
public enum StatType {
    ATK("공격력", 1),
    DEF("방어력", 2),
    SPD("스피드", 3),
    HP("생명력", 4),
    MP("마나", 5);

    private String label;
    private Integer sort;

    StatType(String label, Integer sort) {
        this.label = label;
        this.sort = sort;
    }
}
