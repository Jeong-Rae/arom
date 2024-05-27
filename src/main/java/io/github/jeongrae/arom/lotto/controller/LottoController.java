package io.github.jeongrae.arom.lotto.controller;

import io.github.jeongrae.arom.lotto.domain.Lottos;
import io.github.jeongrae.arom.lotto.domain.PurchaseRecord;
import io.github.jeongrae.arom.lotto.dto.BuyRequest;
import io.github.jeongrae.arom.lotto.dto.BuyResponse;
import io.github.jeongrae.arom.lotto.dto.LottoResponse;
import io.github.jeongrae.arom.lotto.service.LottoService;
import io.github.jeongrae.arom.lotto.service.PurchaseRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lottos")
@RequiredArgsConstructor // auto DI ,final 객체만 DI
public class LottoController {
    private final LottoService lottoService;
    private final PurchaseRecordService purchaseRecordService;

    // 로또 구매
    @PostMapping("/purchases")
    public ResponseEntity<BuyResponse> buyLotto(@RequestBody BuyRequest buyRequest) {
        Lottos lottos = lottoService.generateLotto(buyRequest);
        // 저장하는 부분
        purchaseRecordService.logPurchaseRecord(buyRequest, lottos);

        List<LottoResponse> lottoResponses = lottos.getLottos().stream()
                .map(lotto -> new LottoResponse(lotto.getNumbers()))
                .collect(Collectors.toList());

        BuyResponse response = new BuyResponse(lottoResponses);
        return ResponseEntity.ok(response);
    }

    @GetMapping("purchases")
    public List<PurchaseRecord> findAll() {
        List<PurchaseRecord> purchaseRecords = lottoService.findAll();
        System.out.println(purchaseRecords);
        System.out.println("FIND ALL");

        return purchaseRecords;
    }

    @GetMapping("purchases/{id}")
    public PurchaseRecord findById(@PathVariable Long id) {
        PurchaseRecord purchaseRecord = lottoService.findById(id);

        System.out.println(purchaseRecord);
        return purchaseRecord;
    }


    // repository.find~~~ => SELECT 데이터를 조회
    // repository.save() => UPDATE, INSERT , 데이터를 수정하거나, 생성할때 (데이터를 저장할 떄)

    // repository.delete() =>
}
