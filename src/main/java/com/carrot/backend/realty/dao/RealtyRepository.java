package com.carrot.backend.realty.dao;

import com.carrot.backend.realty.domain.Realty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtyRepository extends JpaRepository<Realty, Integer>, CustomizedRealtyRepository {
}
