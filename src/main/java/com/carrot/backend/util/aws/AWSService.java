//package com.carrot.backend.util.aws;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
//import lombok.RequiredArgsConstructor;
//import lombok.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.io.IOException;
//import java.net.URLEncoder;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class AWSService {
//    private final AmazonS3 amazonS3;
//
//    @Value("${aws.s3.bucket}")
//    private String bucket;
//
//    /**
//     * S3 bucket 파일 다운로드
//     */
//    public ResponseEntity<byte[]> getObject(String storedFileName) throws IOException {
//        S3Object o = amazonS3.getObject(new GetObjectRequest(bucket, storedFileName));
//        S3ObjectInputStream objectInputStream = ((S3Object) o).getObjectContent();
//        byte[] bytes = IOUtils.toByteArray(objectInputStream);
//
//        String fileName = URLEncoder.encode(storedFileName, "UTF-8").replaceAll("\\+", "%20");
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        httpHeaders.setContentLength(bytes.length);
//        httpHeaders.setContentDispositionFormData("attachment", fileName);
//
//        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
//
//    }
//
//}

//https://gksdudrb922.tistory.com/151