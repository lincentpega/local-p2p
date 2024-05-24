package com.lincentpega.localp2p.asset.application;

import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.mappers.AssetMapper;
import com.lincentpega.localp2p.asset.persistence.AssetRepository;
import com.lincentpega.localp2p.common.exceptions.LogicException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    public Iterable<Asset> getAssets() {
        return StreamSupport.stream(assetRepository.findAll().spliterator(), false)
                .map(assetMapper::toAsset)
                .toList();
    }

    public Optional<Asset> getAssetById(long id) {
        return assetRepository.findById(id).map(assetMapper::toAsset);
    }

    public Asset saveAsset(Asset asset) {
        if (assetRepository.existsByName(asset.getName())) {
            throw new LogicException("Asset with id " + asset.getId() + " already exists");
        }
        return assetMapper.toAsset(assetRepository.save(assetMapper.toAssetEntity(asset)));
    }
}
