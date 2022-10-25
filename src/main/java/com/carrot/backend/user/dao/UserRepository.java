package com.carrot.backend.user.dao;


import com.carrot.backend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{

    Optional<User> findByUsername(String username);
}