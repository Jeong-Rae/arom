package io.github.jeongrae.arom.lotto.service;

import io.github.jeongrae.arom.lotto.domain.Lotto;
import io.github.jeongrae.arom.lotto.domain.Lottos;
import io.github.jeongrae.arom.lotto.domain.PurchaseRecord;
import io.github.jeongrae.arom.lotto.dto.BuyRequest;
import io.github.jeongrae.arom.lotto.dto.PurchaseSummary;
import io.github.jeongrae.arom.lotto.repository.PurchaseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LottoService {
    private final PurchaseRecordRepository purchaseRecordRepository;
    private final PurchaseRecordService purchaseRecordService;

    private final LottoGenerator lottoGenerator;
    private final LottoChecker lottoChecker;
    private final static int LOTTO_PRICE = 1000; // 수정이 유리

    @Transactional
    public Lottos generateLotto(BuyRequest request) {
        PurchaseSummary purchaseSummary = purchaseRecordService.findTotalPrice(request);
        if (purchaseSummary.totalPrice() >= 100000) { // 사용자가 구매 금액이 10만원보다 크다면
            log.info("{} 의 {} 회차 구매 금액은 {}원 입니다.", purchaseSummary.purchaserName(), purchaseSummary.drawNumberId(), purchaseSummary.totalPrice());
            throw new IllegalArgumentException();
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < request.amount() / LOTTO_PRICE; i++) {
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public Boolean checkLotto(Lotto lotto) {
        return lottoChecker.check(lotto);
    }

    public Lotto getWinningNumber() {
        return lottoChecker.getWinningNumber();
    }

    public List<PurchaseRecord> findAll() {
        return purchaseRecordRepository.findAll();
    }

    public PurchaseRecord findById(Long id) {
        return purchaseRecordRepository.findById(id).get();
    }
}
