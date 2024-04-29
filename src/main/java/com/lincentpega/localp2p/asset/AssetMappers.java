package com.lincentpega.localp2p.asset;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.persistence.AssetModel;

public class AssetMappers {

    public static AssetModel toModel(Asset asset) {
        return new AssetModel(asset.getId(), asset.getName());
    }

    public static Asset toDomain(AssetModel assetModel) {
        return new Asset(assetModel.getId(), assetModel.getName());
    }
}
