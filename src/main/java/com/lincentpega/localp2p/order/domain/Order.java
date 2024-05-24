package com.lincentpega.localp2p.order.domain;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.paymentmethod.domain.PaymentMethod;
import com.lincentpega.localp2p.user.domain.User;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Long id;
    @NotNull
    private User seller;
    @Nullable
    private User buyer;
    @NotNull
    private Asset assetToSell;
    @NotNull
    private Asset assetToBuy;
    @NotNull
    private BigDecimal sellToBuyRate;
    @NotNull
    private PaymentMethod paymentMethod;
    @Nullable
    private String description;
    @NotNull
    private Instant createdAt;
    @NotNull
    private Instant expiresAt;
}
