package com.lincentpega.localp2p;

import com.lincentpega.localp2p.user.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    boolean existsByName(String name);
}