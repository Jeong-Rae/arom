package io.github.jeongrae.arom.lotto.dto;

import io.github.jeongrae.arom.lotto.domain.PurchaseType;

import java.util.List;

public record BuyResponse(
        List<LottoResponse> lottos
) {
}
