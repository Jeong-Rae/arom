package io.github.jeongrae.arom.lotto.dto;

import io.github.jeongrae.arom.lotto.domain.Lottos;

// @Getterm, @Setter, @ToString, @hasheq , @Data
public record LottosDTO(
        Lottos lottos // response 에 들어갈 변수명
) {
    public static LottosDTO of(Lottos lottos) { // 오버로딩이 자유롭다. //빌더를 못씀
        return new LottosDTO(lottos);
    }
}
