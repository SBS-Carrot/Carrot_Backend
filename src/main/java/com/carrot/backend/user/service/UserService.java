package com.carrot.backend.user.service;

import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User create(String userid,String password, String username, String birth, String email, String nickname, String address, String phone){
        User user = User.builder()
                .userid(userid)
                .password(password)
                .role("ROLE_USER")
                .username(username)
                .birth(birth)
                .email(email)
                .nickname(nickname)
                .address(address)
                .phone(phone)
                .build();
        userRepository.save(user);
        return user;
    }
}
