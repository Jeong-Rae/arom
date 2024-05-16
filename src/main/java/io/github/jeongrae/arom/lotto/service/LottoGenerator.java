package io.github.jeongrae.arom.lotto.service;

import io.github.jeongrae.arom.lotto.domain.Lotto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAX_NUMBER = 45;

    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return new Lotto(numbers);
    }
}
