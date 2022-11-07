package com.carrot.backend.user.controller;

import com.carrot.backend.user.UserLoginForm;
import com.carrot.backend.user.domain.User;
import com.carrot.backend.user.dto.UserDto;
import com.carrot.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDto userDto){
        User user = userService.create(userDto);
        return user;
    }

    @PostMapping("/loginUser")
    public User loginUser (@RequestBody UserLoginForm userLoginForm){
        User user = userService.login(userLoginForm);
        return user;
    }
    @GetMapping("/getUser/{userid}")
    public User _getUser(@PathVariable("userId") String userid){
        User user = userService.getUser(userid);
        return user;
    }

    @GetMapping("/checkId/{userId}")
    public boolean _checkId(@PathVariable("userId") String uid){
        boolean id = userService.checkId(uid);
        return id;
    }
}
