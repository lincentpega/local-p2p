package com.lincentpega.localp2p.order.persistence;

import com.lincentpega.localp2p.asset.persistence.AssetEntity;
import com.lincentpega.localp2p.paymentmethod.persistence.PaymentMethodEntity;
import com.lincentpega.localp2p.user.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserEntity buyer;

    @ManyToOne
    @JoinColumn(name = "asset_to_sell_id", nullable = false)
    private AssetEntity assetToSell;

    @ManyToOne
    @JoinColumn(name = "asset_to_buy_id", nullable = false)
    private AssetEntity assetToBuy;

    @Column(nullable = false)
    private BigDecimal sellToBuyRate;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethodEntity paymentMethod;

    @Column(name = "description")
    private String description;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant expiresAt;
}
