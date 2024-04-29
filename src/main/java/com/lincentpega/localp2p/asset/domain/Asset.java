package com.lincentpega.localp2p.asset.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asset {

    private Long id;
    private String name;

    public Asset(String name) {
        this.name = name;
    }
}
