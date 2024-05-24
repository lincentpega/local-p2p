package com.lincentpega.localp2p.asset.mappers;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.persistence.AssetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetMapper {

    Asset toAsset(AssetEntity assetEntity);

    AssetEntity toAssetEntity(Asset asset);
}
