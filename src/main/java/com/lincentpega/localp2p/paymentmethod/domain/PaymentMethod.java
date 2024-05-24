package com.lincentpega.localp2p.paymentmethod.domain;

import lombok.Data;

@Data
public class PaymentMethod {

    private long id;
    private String name;

    public PaymentMethod(String name) {
        this.name = name;
    }
}
