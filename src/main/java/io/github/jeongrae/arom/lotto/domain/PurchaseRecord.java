package io.github.jeongrae.arom.lotto.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
@Entity
public class PurchaseRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_record_id")
    private Long id;

    @Column(name = "purchaser_name")
    private String purchaserName;

    @Column(name = "draw_number")
    private Long drawNumberId;

    @Column(name = "number_of_tickets")
    private Integer numberOfTickets;

    @Column(name = "purchase_type")
    private PurchaseType purchaseType;

    @Builder
    public PurchaseRecord(Long id, String purchaserName, Long drawNumberId, Integer numberOfTickets, PurchaseType purchaseType) {
        this.id = id;
        this.purchaserName = purchaserName;
        this.drawNumberId = drawNumberId;
        this.numberOfTickets = numberOfTickets;
        this.purchaseType = purchaseType;
    }

    public PurchaseRecord() {

    }
}
