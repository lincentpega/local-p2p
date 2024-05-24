package com.lincentpega.localp2p.asset.mappers;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.persistence.AssetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssetMapper {

    Asset toAsset(AssetEntity assetEntity);

    AssetEntity toAssetEntity(Asset asset);
}
