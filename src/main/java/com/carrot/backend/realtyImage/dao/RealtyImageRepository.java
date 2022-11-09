package com.carrot.backend.realtyImage.dao;

import com.carrot.backend.realtyImage.domain.RealtyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtyImageRepository extends JpaRepository<RealtyImage, Integer> {
}
