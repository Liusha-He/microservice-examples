package org.liusha.users.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.liusha.users.data.UsersRepository;
import org.liusha.users.model.CreateUserRequestModel;
import org.liusha.users.model.LoginRequestModel;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
public class TestUserController {
    private MockMvc mvc;

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UserController userController;

    private JacksonTester<CreateUserRequestModel> createUserRequest;
    private JacksonTester<LoginRequestModel> loginRequest;

    @BeforeEach
    public void setup() {
        System.out.println("test");
    }

    @Test public void testCreateUser() {
        System.out.println("test");
    }
}
