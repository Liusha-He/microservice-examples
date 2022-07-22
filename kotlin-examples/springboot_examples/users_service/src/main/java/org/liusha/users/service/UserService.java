package org.liusha.users.service;

import org.liusha.users.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDetail);
    UserDto getUserDetailsByEmail(String email);
}
