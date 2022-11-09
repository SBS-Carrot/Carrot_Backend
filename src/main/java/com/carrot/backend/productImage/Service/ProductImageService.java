package com.carrot.backend.productImage.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.productImage.dao.ProductImageRepository;
import com.carrot.backend.productImage.domain.ProductImages;
import com.carrot.backend.productImage.dto.ProductImageDto;
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
public class ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductService productService;
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


    public List<ProductImageDto> uploads(Integer productId, List<MultipartFile> multipartFile, String dirName) throws IOException {
        List<File> uploadFile = new ArrayList<File>();
        for(int i=0;i< multipartFile.size();i++) {
            System.out.println("size:"+multipartFile.size());

            MultipartFile files = multipartFile.get(i);
            File upload = convert(files)
                    .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));
            uploadFile.add(upload);
        }



        return upload(productId, uploadFile, dirName);
    }



        private List<ProductImageDto> upload (Integer productId, List<File> uploadFile, String dirName){
                List<ProductImageDto> images = new ArrayList<>();
                for(int i=0;i< uploadFile.size();i++){
                    String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.get(i).getName();


                    String path = putS3(uploadFile.get(i), fileName);

                    removeNewFile(uploadFile.get(i));
                    ProductImageDto image = new ProductImageDto(productId,path);
                    images.add(i,image);

                    ProductImages productImages = new ProductImages();
                    productImages.setPath(path);
                    productImages.setProduct(productService.getProduct(productId));
                    productImageRepository.save(productImages);

                }
//FileUploadResponse DTO로 반환해준다.
            return images;
            //return uploadImageUrl;
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
