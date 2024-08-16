package com.biglikuryer.bigliplus.service.impl.advert;

import com.biglikuryer.bigliplus.dao.advert.AdvertRepository;
import com.biglikuryer.bigliplus.dto.advert.AdvertDto;
import com.biglikuryer.bigliplus.model.advert.Advert;
import com.biglikuryer.bigliplus.service.inter.advert.AdvertServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvertServiceImpl implements AdvertServiceInter {

    private final AdvertRepository advertRepository;
    private final ModelMapper modelMapper;

    public AdvertServiceImpl(AdvertRepository advertRepository, ModelMapper modelMapper) {
        this.advertRepository = advertRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdvertDto createAdvert(AdvertDto advertDto) {
        Advert advert = modelMapper.map(advertDto, Advert.class);
        advert = advertRepository.save(advert);
        return modelMapper.map(advert, AdvertDto.class);
    }

    @Override
    public List<AdvertDto> getAllAdverts() {
        List<Advert> adverts = advertRepository.findAll();
        return adverts.stream()
                .map(advert -> modelMapper.map(advert, AdvertDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertDto getAdvertById(Long advertId) {
        Optional<Advert> advertOptional = advertRepository.findById(advertId);
        return advertOptional.map(advert -> modelMapper.map(advert, AdvertDto.class)).orElse(null);
    }

    @Override
    public AdvertDto updateAdvert(Long advertId, AdvertDto advertDto) {
        Optional<Advert> advertOptional = advertRepository.findById(advertId);
        if (advertOptional.isPresent()) {
            Advert advert = advertOptional.get();

            if (advertDto.getUserId() != null) {
                advert.setUserId(advertDto.getUserId());
            }

            if (advertDto.getMode() != null) {
                advert.setMode(advertDto.getMode());
            }

            if (advertDto.getPremiumExpiredDate() != null) {
                advert.setPremiumExpiredDate(advertDto.getPremiumExpiredDate());
            }

            if (advertDto.getHaveWhatsapp() != null) {
                advert.setHaveWhatsapp(advertDto.getHaveWhatsapp());
            }

            if (advertDto.getHaveHelmet() != null) {
                advert.setHaveHelmet(advertDto.getHaveHelmet());
            }

            if (advertDto.getDescription() != null) {
                advert.setDescription(advertDto.getDescription());
            }

            if (advertDto.getViewCount() != null) {
                advert.setViewCount(advertDto.getViewCount());
            }

            if (advertDto.getCreatedDate() != null) {
                advert.setCreatedDate(advertDto.getCreatedDate());
            }

            advert = advertRepository.save(advert);
            return modelMapper.map(advert, AdvertDto.class);

        }
        return null;
    }

    @Override
    public Boolean removeById(Long advertId) {
        Optional<Advert> advertOptional = advertRepository.findById(advertId);
        if (advertOptional.isPresent()) {
            Advert advert = advertOptional.get();
            advertRepository.delete(advert);
            return true;
        }
        return false;
    }
}
