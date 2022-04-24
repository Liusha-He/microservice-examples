package org.liusha.users.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {
    @NotNull(message = "First name is required")
    @Size(min = 2, message = "First name must not be less than 2 characters")
    private String firstName;
    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 20, message = "Password must contains 6-20 characters.")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
