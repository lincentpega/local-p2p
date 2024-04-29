package com.lincentpega.localp2p.asset.application;

import com.lincentpega.localp2p.asset.AssetMappers;
import com.lincentpega.localp2p.asset.domain.Asset;
import com.lincentpega.localp2p.asset.persistence.AssetRepository;
import com.lincentpega.localp2p.exceptions.AlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Iterable<Asset> getAssets() {
        return StreamSupport.stream(assetRepository.findAll().spliterator(), false)
                .map(AssetMappers::toDomain)
                .toList();
    }

    public Optional<Asset> getAssetById(long id) {
        return assetRepository.findById(id).map(AssetMappers::toDomain);
    }

    public Asset saveAsset(Asset asset) {
        if (assetRepository.existsByName(asset.getName())) {
            throw new AlreadyExistsException("Asset with id " + asset.getId() + " already exists");
        }
        return AssetMappers.toDomain(assetRepository.save(AssetMappers.toModel(asset)));
    }
}
