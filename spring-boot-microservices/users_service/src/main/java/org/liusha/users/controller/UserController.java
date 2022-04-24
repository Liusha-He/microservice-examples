package org.liusha.users.controller;

import org.liusha.users.model.UserModel;
import org.liusha.users.service.UserService;
import org.liusha.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping()
    public String createUser(@Valid @RequestBody UserModel userDetail)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetail, UserDto.class);
        userService.createUser(userDto);

        return "createUser method called...";
    }
}
