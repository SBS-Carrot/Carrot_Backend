package com.carrot.backend.realty.controller;

import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realty.dto.RealtyDto;
import com.carrot.backend.realty.service.RealtyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RealtyController {

    private final RealtyService realtyService;

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
}
