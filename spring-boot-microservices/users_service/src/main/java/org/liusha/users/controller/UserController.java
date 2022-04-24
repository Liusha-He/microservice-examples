package org.liusha.users.controller;

import org.liusha.users.model.UserRequestModel;
import org.liusha.users.model.UserResponseModel;
import org.liusha.users.service.UserService;
import org.liusha.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status()
    {
        return "Success";
    }

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userDetail)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetail, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);
        UserResponseModel returnValue = modelMapper.map(createdUser, UserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
