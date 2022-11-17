package com.carrot.backend.realty.dao;

import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realtyLike.domain.RealtyLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealtyRepository extends JpaRepository<Realty, Integer>, CustomizedRealtyRepository {
    Optional<Realty> findByRealtyId(Integer realtyid);
}
