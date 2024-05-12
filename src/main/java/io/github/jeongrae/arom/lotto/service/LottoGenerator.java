package io.github.jeongrae.arom.lotto.service;

import io.github.jeongrae.arom.lotto.domain.Lotto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // spring framwork 에서 관리하게됩니다. 이때 DI가 가능해짐
public class LottoGenerator {
    private static List<Integer> numbers = List.of(1,2,3,4,5,6);
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
