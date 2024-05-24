package com.lincentpega.localp2p.order.domain;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.paymentmethod.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Asset assetToSell;
    private Asset assetToBuy;
    private BigDecimal sellToBuyRate;
    private PaymentMethod paymentMethod;
    private Instant createdAt;
    private Instant expiresAt;
}
