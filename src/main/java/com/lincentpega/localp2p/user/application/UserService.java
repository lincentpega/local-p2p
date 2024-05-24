package com.lincentpega.localp2p.user.application;

import com.lincentpega.localp2p.UserRepository;
import com.lincentpega.localp2p.user.persistence.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userRepository.save(userEntity);
    }

    public boolean userExists(String name) {
        return userRepository.existsByName(name);
    }
}
