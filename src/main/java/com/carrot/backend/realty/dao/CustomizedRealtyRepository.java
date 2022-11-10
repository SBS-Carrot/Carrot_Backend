package com.carrot.backend.realty.dao;

import com.carrot.backend.realty.domain.Realty;

public interface CustomizedRealtyRepository {
    Realty getQslRealty(Integer id);
}
