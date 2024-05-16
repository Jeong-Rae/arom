package io.github.jeongrae.arom.lotto.repository;

import io.github.jeongrae.arom.lotto.domain.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

    Optional<PurchaseRecord> findById(Long id);
}
