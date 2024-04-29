package com.lincentpega.localp2p.asset.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "asset")
public class AssetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public AssetModel(String name) {
        this.name = name;
    }

    public AssetModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}