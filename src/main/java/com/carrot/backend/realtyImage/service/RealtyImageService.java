package com.carrot.backend.realtyImage.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.carrot.backend.realty.service.RealtyService;
import com.carrot.backend.realtyImage.dao.RealtyImageRepository;
import com.carrot.backend.realtyImage.domain.RealtyImage;
import com.carrot.backend.realtyImage.dto.RealtyImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

@Slf4j
@Service
@RequiredArgsConstructor
@Component
public class RealtyImageService {
    private final AmazonS3Client amazonS3Client;
    private final RealtyImageRepository realtyImageRepository;
    private final RealtyService realtyService;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public List<RealtyImageDto> uploads(Integer realtyId, List<MultipartFile> multipartFile, String dirName) throws IOException {
        List<File> uploadFile = new ArrayList<File>();
        for(int i=0;i< multipartFile.size();i++) {
            System.out.println("size :"+multipartFile.size());

            MultipartFile files = multipartFile.get(i);
            File upload = convert(files)
                    .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));
            uploadFile.add(upload);
        }

        return upload(realtyId, uploadFile, dirName);
    }

    private List<RealtyImageDto> upload (Integer realtyId, List<File> uploadFile, String dirName) {
        List<RealtyImageDto> images = new ArrayList<>();
        for (int i = 0; i < uploadFile.size(); i++) {
            String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.get(i).getName();


            String path = putS3(uploadFile.get(i), fileName);

            removeNewFile(uploadFile.get(i));
            RealtyImageDto image = new RealtyImageDto(realtyId, path);
            images.add(i, image);


            RealtyImage realtyImage = new RealtyImage();
            realtyImage.setRealtyPath(path);
            realtyImage.setRealty(realtyService.getRealty(realtyId));
            realtyImageRepository.save(realtyImage);
        }
        return images;
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