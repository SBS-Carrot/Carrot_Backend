package com.carrot.backend.user.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.carrot.backend.productImage.domain.ProductImages;
import com.carrot.backend.productImage.dto.ProductImageDto;
import com.carrot.backend.user.UserLoginForm;
import com.carrot.backend.user.dao.UserRepository;
import com.carrot.backend.user.domain.User;
import com.carrot.backend.user.dto.UserDto;
import com.carrot.backend.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Component
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public User create(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String username = userDto.getUsername();
        String userid = userDto.getUserid();
        String password = userDto.getPassword();
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
                .password(passwordEncoder.encode(password))
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
        try {
            Optional<User> user = this.userRepository.findByUserid(userid);
            if (user.isPresent()) {
                return user.get();
            }
        }catch(DataNotFoundException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean checkId(String userid) {
        Optional<User> user = userRepository.findByUserid(userid);
        if(user.isPresent()){
            return false;
        }else{
            return true;
        }

    }

    public String login(UserLoginForm userLoginForm) throws UsernameNotFoundException{
        User user = getUser(userLoginForm.getUserid());

        if(user==null){
            return "false";
        }

        if(passwordEncoder.matches(userLoginForm.getPassword(),user.getPassword())) {
            return ("true"+user.getUserid());
        }else {

            return "false";
        }

    }

    public void changeUserProfileImage(UserDto userdto, List<MultipartFile> multipartFile, String users) {
        List<File> uploadFile = new ArrayList<File>();
        for(int i=0;i< multipartFile.size();i++) {


            MultipartFile files = multipartFile.get(i);
            File upload = null;
            try {
                upload = convert(files)
                        .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            uploadFile.add(upload);
        }





        }



        private void upload (UserDto userdto, List<File> uploadFile, String dirName){
                String userid = userdto.getUserid();
                String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.get(0).getName();


                String path = putS3(uploadFile.get(0), fileName);

                removeNewFile(uploadFile.get(0));
                User user = userRepository.findByUserid(userid).orElseThrow(()-> new DataNotFoundException("user not found"));

                user.setProfileImage(path);
                user.setNickname(userdto.getNickname());
                userRepository.save(user);



        }

        private String putS3 (File uploadFile, String fileName){
            amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(
                    CannedAccessControlList.PublicRead));


            return amazonS3Client.getUrl(bucket, fileName).toString();
        }

        private void removeNewFile (File targetFile){
            if (targetFile.delete()) {
                log.info("파일이 삭제되었습니다.");
            } else {
                log.info("파일이 삭제되지 못했습니다.");
            }
        }

        private Optional<File> convert (MultipartFile file) throws IOException {


            File convertFile = new File(file.getOriginalFilename());

            if (convertFile.createNewFile()) {

                try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                    fos.write(file.getBytes());
                }
                return Optional.of(convertFile);
            }

            return Optional.empty();
        }


    }

