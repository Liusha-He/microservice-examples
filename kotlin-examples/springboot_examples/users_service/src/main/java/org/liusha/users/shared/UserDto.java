package org.liusha.users.shared;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private static final Long serialVersionUID = -953297098295050686L;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userID;
    private String encryptedPassword;
}
