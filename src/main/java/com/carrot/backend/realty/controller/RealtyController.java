package com.carrot.backend.realty.controller;

import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realty.dto.RealtyDto;
import com.carrot.backend.realty.service.RealtyService;
import com.carrot.backend.realtyImage.service.RealtyImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class RealtyController {

    private final RealtyService realtyService;
    private final RealtyImageService realtyImageService;

    @GetMapping("/realty")
    public List<Realty> getsRealty(){
        return realtyService.getsRealty();
    }

   @GetMapping("/realty/{realtyId}")
    public Realty getRealty(@PathVariable Integer realtyId){
        return realtyService.getRealty(realtyId);
   }

   @PostMapping("/createRealty")
    public Realty createRealty(@RequestBody RealtyDto realtyDto){
        Integer id = realtyService.createRealty(realtyDto);
        return realtyService.getRealty(id);
   }

    @PostMapping("createRealtyImages")
    public Realty createRealtyImg(@RequestPart(value = "realtyDto") RealtyDto realtyDto, @RequestPart("file") List<MultipartFile> multipartFile) throws IOException {
        Integer id = realtyService.createRealty(realtyDto);
        realtyImageService.uploads(id, multipartFile, "realtyImages");
        return realtyService.getRealty(id);
    }
}
