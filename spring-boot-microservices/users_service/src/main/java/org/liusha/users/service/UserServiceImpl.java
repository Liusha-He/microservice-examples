package org.liusha.users.service;

import org.liusha.users.data.UserEntity;
import org.liusha.users.data.UsersRepository;
import org.liusha.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service public class UserServiceImpl implements UserService {
    UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetail) {
        userDetail.setUserID(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetail, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        usersRepository.save(userEntity);

        return modelMapper.map(userEntity, UserDto.class);
    }
}
