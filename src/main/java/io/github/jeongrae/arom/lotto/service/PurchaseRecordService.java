package io.github.jeongrae.arom.lotto.service;

import io.github.jeongrae.arom.lotto.domain.Lottos;
import io.github.jeongrae.arom.lotto.domain.PurchaseRecord;
import io.github.jeongrae.arom.lotto.dto.BuyRequest;
import io.github.jeongrae.arom.lotto.dto.PurchaseSummary;
import io.github.jeongrae.arom.lotto.repository.PurchaseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseRecordService {
    private final PurchaseRecordRepository purchaseRecordRepository;

    //
    @Transactional // 트랙잭션 설정 -> rollback
    public PurchaseRecord logPurchaseRecord(BuyRequest request, Lottos lottos) {
        // 저장할 엔티티 생성
        PurchaseRecord purchaseRecord = PurchaseRecord
                .builder()
                .purchaserName(request.purchaserName())
                .purchaseType(request.purchaseType())
                .drawNumberId(1L)
                .numberOfTickets(lottos.getLottos().size())
                .build();

        purchaseRecord = purchaseRecordRepository.save(purchaseRecord); // 저장 + id 발급
        log.info("[logPurchaseRecord] {}", purchaseRecord);
        return purchaseRecord;
    }

    @Transactional
    public PurchaseSummary findTotalPrice(BuyRequest request) {
        return purchaseRecordRepository.findPurchaseSummaries(request.purchaserName(), request.drawNumberId());
    }
}
