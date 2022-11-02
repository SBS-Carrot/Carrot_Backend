package com.carrot.backend.product.domain;

import com.carrot.backend.productImage.domain.ProductImages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;
    @Column(length = 40)
    @NotEmpty
    String productSubject;
    @Column(length = 200)
    @NotEmpty
    String productContent;
    @Column
    @NotEmpty
    String productPrice;
    @Column
    Integer productChatting;
    @Column
    Integer productView;
    @Column
    Integer productLike;

    @Column
    @NotEmpty
    String productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<ProductImages> images;


}
//public class User
////        implements UserDetails
//{
//
//
//    private String userid;
//
//    private String password;

//    private String role;
//
//    @Id
//    @Size(min = 5, max=20)
//    @NotEmpty
//    private String userid;
//
//    @Size( min = 8,max=20)
//    @NotEmpty
//    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")
//    private String password;
//
//    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
//    private String password2;
//
//    @NotEmpty(message = "이름은 필수 항목입니다.")
//    private String username;
//
//    @NotEmpty(message = "생년월일은 필수 항목입니다.")
//    private String birth;
//
//    @Column(unique = true)
//    @Email(message = "이메일 형식에 맞지 않습니다.")
//    private String email;
//
//    @Size(min = 4,max = 16)
//    private String nickname;
//
//    @NotEmpty(message = "연락처는 필수항목입니다.")
//    private String phone;
//
//    @NotEmpty(message = "주소는 필수항목입니다.")
//    private String address;
//
//    private String temp;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collect = new ArrayList<>();
//        collect.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return getRole();
//            }
//        });
//        return collect;
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}