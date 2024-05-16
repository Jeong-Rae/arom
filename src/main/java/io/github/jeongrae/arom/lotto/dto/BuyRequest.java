package io.github.jeongrae.arom.lotto.dto;

import io.github.jeongrae.arom.lotto.domain.PurchaseType;

public record BuyRequest(
        String purchaserName,
        Integer amount,
        PurchaseType purchaseType
) {
}
