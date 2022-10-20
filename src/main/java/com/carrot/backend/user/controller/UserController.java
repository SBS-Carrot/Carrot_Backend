package com.carrot.backend.user.controller;

import com.carrot.backend.user.domain.User;
import com.carrot.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/login")
    public String login(){
        return "redirect:http://localhost:3000/login";
    }

    @PostMapping("/create")
    public String signup(@RequestBody String userid
    ) {
        System.out.println("userid"+userid);

//        try{
//            User user = userService.create(userid,
//                    password,
//                    username,
//                    birth,
//                    email,
//                    nickname,
//                    address,
//                    phone
//            );
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        return "redirect:http://localhost:3000/login";
    }

    private final UserService userService;

    @GetMapping("/create")
    public String sign(){
        System.out.println("h");
        return "hi";
    }
}