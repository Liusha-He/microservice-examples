package org.liusha.users.service;

import org.liusha.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetail);
}
