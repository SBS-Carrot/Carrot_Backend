package com.carrot.backend.util.aws;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AWSController {

    private final AWSService awsService;

    @GetMapping("/csv_download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
        return awsService.getObject(fileName);
    }
}
