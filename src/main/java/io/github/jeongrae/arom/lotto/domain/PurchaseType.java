package io.github.jeongrae.arom.lotto.domain;

import lombok.Getter;

@Getter
public enum PurchaseType {
    AUTO("자동"),
    MANUAL("수동");

    private final String description;

    PurchaseType(String description) {
        this.description = description;
    }
}
