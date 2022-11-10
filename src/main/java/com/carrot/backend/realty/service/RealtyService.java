package com.carrot.backend.realty.service;

import com.carrot.backend.realty.dao.RealtyRepository;
import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realty.dto.RealtyDto;
import com.carrot.backend.util.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RealtyService {

    private final RealtyRepository realtyRepository;

    public List<Realty> getsRealty(){
        return realtyRepository.findAll();
    }

    public Realty getRealty(Integer realtyId){
        return realtyRepository.findById(realtyId).orElseThrow(() -> new DataNotFoundException("realty not found"));
    }

    public Integer createRealty(RealtyDto realtyDto) {
        Realty newRealty = new Realty();

        newRealty.setRealtyWho(realtyDto.getRealtyWho());
        newRealty.setRealtyCategory(realtyDto.getRealtyCategory());
        newRealty.setRealtySpace(realtyDto.getRealtySpace());
        newRealty.setRealtyArea(realtyDto.getRealtyArea());
        newRealty.setRealtyRoom(realtyDto.getRealtyRoom());
        newRealty.setRealtyBath(realtyDto.getRealtyBath());
        newRealty.setRealtyAddress(realtyDto.getRealtyAddress());
        newRealty.setRealtyWhole(realtyDto.getRealtyWhole());
        newRealty.setRealtyFloor(realtyDto.getRealtyFloor());
        newRealty.setRealtyMove(realtyDto.getRealtyMove());
        newRealty.setRealtyMoveDate(realtyDto.getRealtyMoveDate());
        newRealty.setRealtyLoan(realtyDto.getRealtyLoan());
        newRealty.setRealtyPet(realtyDto.getRealtyPet());
        newRealty.setRealtyParking(realtyDto.getRealtyParking());
        newRealty.setRealtyElevator(realtyDto.getRealtyElevator());
        String[] insideArr = realtyDto.getRealtyInside();
        String tmp2 = "";
        if(insideArr.length == 0){
            newRealty.setRealtyInside("없음");
        }else {
            for(int i = 0; i < insideArr.length; i++){
                String tmp = insideArr[i];
                tmp2 += "," + tmp;
            }
        }
        String tmp3 = tmp2.substring(1);
        newRealty.setRealtyInside(tmp3);
        newRealty.setRealtyContent(realtyDto.getRealtyContent());
        newRealty.setCreateDate(LocalDateTime.now());
        newRealty.setRealtyDeposit(realtyDto.getRealtyDeposit());
        newRealty.setRealtyMonthly(realtyDto.getRealtyMonthly());
        newRealty.setRealtyShortTerm(realtyDto.getRealtyShortTerm());
        newRealty.setRealtyChangePrice(realtyDto.getRealtyChangePrice());
        newRealty.setRealtyDepositChange(realtyDto.getRealtyDepositChange());
        newRealty.setRealtyCost(realtyDto.getRealtyCost());
        newRealty.setRealtyCostContent(realtyDto.getRealtyCostContent());
        newRealty.setRealtySalePrice(realtyDto.getRealtySalePrice());
        newRealty.setRealtyDeal(realtyDto.getRealtyDeal());
        newRealty.setRealtyCheck(0);
        newRealty.setRealtyChatting(0);
        newRealty.setRealtyDealing("판매중");
        newRealty.setRealtyUserid("user");
        newRealty.setRealtyLike(0);
        realtyRepository.save(newRealty);

        return newRealty.getRealtyId();

    }
}