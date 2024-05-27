package io.github.jeongrae.arom.lotto.dto;

import java.util.List;

public record BuyResponse(
        List<LottoResponse> lottos
) {
}
