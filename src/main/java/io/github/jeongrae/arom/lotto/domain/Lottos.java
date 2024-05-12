package io.github.jeongrae.arom.lotto.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @ToString
public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
