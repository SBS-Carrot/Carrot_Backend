package com.carrot.backend.productImage.controller;

import com.carrot.backend.product.Service.ProductService;
import com.carrot.backend.productImage.Service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class ProductImageController {
    private final ProductService productService;
    private final ProductImageService productImageService;

    @PostMapping("/createProductImages")
    public void createImages(@ModelAttribute MultipartFile[] uploadFile){
        String uploadFolder = "C:\\upload";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);

        String datePath = str.replace("-", File.separator);

        File uploadPath = new File(uploadFolder, datePath);

        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

    }


}
