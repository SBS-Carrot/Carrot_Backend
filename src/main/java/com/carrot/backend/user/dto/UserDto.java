package com.carrot.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDto {
    private String userid;

    private String password;

    private String username;

    private String birth;

    private String address;

    private String email;

    private String nickname;

    private String phone;



}
