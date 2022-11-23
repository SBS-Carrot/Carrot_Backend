package com.carrot.backend.realty.controller;

import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realty.dto.RealtyDto;
import com.carrot.backend.realty.service.RealtyService;
import com.carrot.backend.realtyImage.service.RealtyImageService;
import com.carrot.backend.realtyLike.service.RealtyLikeService;
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

    private final RealtyLikeService realtyLikeService;
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

    @PostMapping("/createRealtyImages")
    public Realty createRealtyImg(@RequestPart(value = "realtyDto") RealtyDto realtyDto, @RequestPart("file") List<MultipartFile> multipartFile) throws IOException {
        Integer id = realtyService.createRealty(realtyDto);
        realtyImageService.uploads(id, multipartFile, "realtyImages");
        return realtyService.getRealty(id);
    }

    @GetMapping("/getRealtyWithImage/{realtyId}")
    public RealtyDto getRealtyAndImages(@PathVariable Integer realtyId){
        return realtyService.getRealtyAndImage(realtyId);
    }

    @GetMapping("/likeRealtyCheck/{realtyId}")
    public boolean isLikedRealty(@RequestParam Integer realtyId,@RequestParam  String userid){
        return realtyLikeService.checkLikeRealty(realtyId, userid);
    }

    @GetMapping("/likeRealty/{realtyId}")
    public boolean likeRealty(@RequestParam Integer realtyId,@RequestParam String userid){
        return realtyLikeService.addRealtyLike(realtyId,userid);
    }

    @PostMapping("/realtyCheck/{realtyId}")
    public void realtyCheck (@PathVariable Integer realtyId){
        realtyService._realtyCheck(realtyId);
    }

    @PostMapping("/realtyDelete/{realtyId}")
    public void realtyDelete(@PathVariable Integer realtyId){
        realtyImageService.realtyDelete(realtyId, "realtyImages");
    }
}
