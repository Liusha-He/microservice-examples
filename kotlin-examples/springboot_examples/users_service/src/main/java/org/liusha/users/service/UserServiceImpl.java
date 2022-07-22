package org.liusha.users.service;

import org.liusha.users.data.UserEntity;
import org.liusha.users.data.UsersRepository;
import org.liusha.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service 
public class UserServiceImpl implements UserService {
    UsersRepository usersRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDetail) {
        userDetail.setUserID(UUID.randomUUID().toString());
        userDetail.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetail.getPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetail, UserEntity.class);


        usersRepository.save(userEntity);

        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByEmail(username);
        if (userEntity == null) throw new UsernameNotFoundException(username);

        return new User(
                userEntity.getEmail(),
                userEntity.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>());
    }

    @Override public UserDto getUserDetailsByEmail(String email) {
        UserEntity userEntity = usersRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new ModelMapper().map(userEntity, UserDto.class);
    }
}
