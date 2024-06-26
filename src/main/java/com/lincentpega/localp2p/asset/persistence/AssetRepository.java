package com.lincentpega.localp2p.asset.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<AssetEntity, Long> {

    boolean existsByName(String name);
}
