package io.github.jeongrae.arom.lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString
@Builder
public class Lotto {
    @Builder.Default
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
