package io.github.jeongrae.arom.lotto.service;

import io.github.jeongrae.arom.lotto.domain.Lotto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // spring framwork 에서 관리하게됩니다. 이때 DI가 가능해짐
public class LottoChecker {
    private static List<Integer> winningNumbers = List.of(2,33,31,4,5,6);
    public boolean check(Lotto lotto) {
       return winningNumbers.equals(lotto.getNumbers());
    }

    public Lotto getWinningNumber() {
        return new Lotto(winningNumbers);
    }
}
