package com.carrot.backend.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Joinform {

    @Id
    @Size(min = 5, max=20)
    @NotEmpty(message = "ID는 필수항목입니다.")
    private String userid;

    @Size( min = 8,max=20)
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이름은 필수 항목입니다.")
    private String username;

    @NotEmpty(message = "생년월일은 필수 항목입니다.")
    private String birth;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Size(min = 4,max = 16)
    private String nickname;

    @NotEmpty(message = "연락처는 필수항목입니다.")
    private String phone;

    @NotEmpty(message = "주소는 필수항목입니다.")
    private String address;

    private String temp;
    //온도
}
