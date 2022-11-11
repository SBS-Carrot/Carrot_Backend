package com.carrot.backend.dao;

import com.carrot.backend.product.dao.ProductRepository;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class CreateUserTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    @Test
    public void createTest() {

        String username = "테스트";
        String userid = "user12";
        String password = "user1234!";
        String birth = "2000-01-01";

        String address = "대전시 서구 둔산동";
        String email = "이메일 없음";
        String nickname = "닉네임 없음";

        String phone = "010-1234-5678";
        User user = User.builder()
                .username(username)
                .userid(userid)
                .password(password)
                .birth(birth)
                .address(address)
                .email(email)
                .nickname(nickname)
                .phone(phone)
                .role("ROLE_USER")
                .temp(36.5)
                .build();

        userRepository.save(user);
    }
}
