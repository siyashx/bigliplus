package com.biglikuryer.bigliplus.service.inter.advert;

import com.biglikuryer.bigliplus.dto.advert.AdvertDto;

import java.util.List;

public interface AdvertServiceInter {

    AdvertDto createAdvert(AdvertDto advertDto);

    List<AdvertDto> getAllAdverts();

    Boolean removeById(Long advertId);

    AdvertDto getAdvertById(Long advertId);

    AdvertDto updateAdvert(Long advertId, AdvertDto advertDto);
}
