package io.github.jeongrae.arom.lotto.dto;

public record PurchaseSummary(
        String purchaserName,
        Long drawNumberId,
        Long totalPrice
) {
}
