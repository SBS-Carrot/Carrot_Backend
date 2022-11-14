package com.carrot.backend.realty.dao;

import com.carrot.backend.product.dto.ProductDto;
import com.carrot.backend.realty.domain.Realty;
import com.carrot.backend.realty.dto.RealtyDto;
import com.carrot.backend.user.dto.UserDto;

public interface CustomizedRealtyRepository {

    RealtyDto getQslRealtyAndImagesByRealtyId(Integer realtyId);
}
