package com.biglikuryer.bigliplus.dao.advert;

import com.biglikuryer.bigliplus.model.advert.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}