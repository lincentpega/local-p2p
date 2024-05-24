package com.lincentpega.localp2p.user.mappers;

import com.lincentpega.localp2p.user.domain.User;
import com.lincentpega.localp2p.user.persistence.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);
}