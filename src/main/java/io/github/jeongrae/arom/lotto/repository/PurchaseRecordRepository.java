package io.github.jeongrae.arom.lotto.repository;

import io.github.jeongrae.arom.lotto.domain.PurchaseRecord;
import io.github.jeongrae.arom.lotto.dto.PurchaseSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

    Optional<PurchaseRecord> findById(Long id);

    @Query("SELECT new io.github.jeongrae.arom.lotto.dto.PurchaseSummary(p.purchaserName, p.drawNumberId, (SUM(p.numberOfTickets)) * 1000L) " +
            "FROM PurchaseRecord p " +
            "WHERE p.purchaserName = :purchaserName AND p.drawNumberId = :drawNumberId " +
            "GROUP BY p.purchaserName, p.drawNumberId")
    PurchaseSummary findPurchaseSummaries(String purchaserName, Long drawNumberId);
}
