package com.carrot.backend.user.service;

import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import com.carrot.backend.user.dto.UserDto;
import com.carrot.backend.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User create(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String username = userDto.getUsername();
        String userid = userDto.getUserid();
        String password = userDto.getPassword();
        String password2 = userDto.getPassword2();
        String birth = userDto.getBirth().replaceAll("[^0123456789]","");
        String year = birth.substring(0,4);
        String month = birth.substring(4,6);
        String day = birth.substring(6);
        birth = (year + "-" + month + "-" + day);

        String address = userDto.getAddress();
        String email;
        if(userDto.getEmail()!="") {
            email = userDto.getEmail();
        }else {
            email = "이메일 없음";
        }
        String nickname;


        if(userDto.getNickname()!=""){
            nickname = userDto.getNickname();
        }else {
            nickname = "닉네임 없음";
        }
        String phone = userDto.getPhone();
        User user = User.builder()
                .username(username)
                .userid(userid)
                .password(password)
                .password2(password2)
                .birth(birth)
                .address(address)
                .email(email)
                .nickname(nickname)
                .phone(phone)
                .role("ROLE_USER")
                .temp(36.5)
                .build();

        userRepository.save(user);

        return user;
    }
    public User getUser(String userid) {
        Optional<User> user = this.userRepository.findByUserid(userid);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException("user not found");
        }
    }

    public boolean checkId(String userid) {
        Optional<User> user = userRepository.findByUserid(userid);
        if(user.isPresent()){
            return false;
        }else{
            return true;
        }

    }
}
