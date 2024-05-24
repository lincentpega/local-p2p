package com.lincentpega.localp2p.asset.domain;

import lombok.Data;

@Data
public class Asset {

    private Long id;
    private String name;
    private Boolean isFiat;

    public Asset(String name, boolean isFiat) {
        this.name = name;
        this.isFiat = isFiat;
    }
}
