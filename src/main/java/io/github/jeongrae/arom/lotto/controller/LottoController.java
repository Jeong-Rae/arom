package io.github.jeongrae.arom.lotto.controller;

import io.github.jeongrae.arom.lotto.domain.Lotto;
import io.github.jeongrae.arom.lotto.domain.Lottos;
import io.github.jeongrae.arom.lotto.dto.LottosDTO;
import io.github.jeongrae.arom.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lottos")
@RequiredArgsConstructor // auto DI ,final 객체만 DI
public class LottoController {
    private final LottoService lottoService;
    // 로또 구매
    @GetMapping() //컨트롤러 메서드는 명은 client입장,
    ResponseEntity<LottosDTO> buyLotto(@RequestParam(name = "amount") Integer amount) {
        Lottos lottos = lottoService.createLotto(amount);

        LottosDTO lottosDTO = LottosDTO.of(lottos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(lottosDTO);
    }

    // 당첨번호 조회
    @GetMapping("winning-number")
    ResponseEntity<?> getWinningLottoNumber() {
        Lotto lotto = lottoService.getWinningNumber();

        return ResponseEntity.status(HttpStatus.OK).body(lotto);
    }


    // 당첨 여부 조회
    @PostMapping("check")
    ResponseEntity<?> checkLotto() {
        boolean result = true;// lottoService.checkLotto();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
