package com.biglikuryer.bigliplus.service.impl.restaurant;

import com.biglikuryer.bigliplus.dao.restaurant.RestaurantRepository;
import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import com.biglikuryer.bigliplus.model.restaurant.Restaurant;
import com.biglikuryer.bigliplus.service.inter.restaurant.RestaurantServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantServiceInter {

    private final RestaurantRepository restaurantRepository;
    private final ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, ModelMapper modelMapper) {
        this.restaurantRepository = restaurantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantDto> listDto = new ArrayList<>();

        List<Restaurant> listEntity = restaurantRepository.findAll();

        for (Restaurant entity : listEntity) {
            RestaurantDto dto = modelMapper.map(entity, RestaurantDto.class);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant entity = restaurantRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, RestaurantDto.class);
        }
        return null;
    }

    @Override
    public ResponseEntity<RestaurantDto> createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurantEntity = modelMapper.map(restaurantDto, Restaurant.class);
        if (isRestaurantPhoneNumberTaken(restaurantEntity.getPhoneNumber())) {
            return ResponseEntity.badRequest().build();
        }
        restaurantEntity.setIsDisable(false);
        Restaurant savedRestaurant = restaurantRepository.save(restaurantEntity);
        return ResponseEntity.ok(modelMapper.map(savedRestaurant, RestaurantDto.class));

    }

    @Override
    public RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDto) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();

            if (restaurantDto.getOneSignal() != null) {
                restaurant.setOneSignal(restaurantDto.getOneSignal());
            }
            if (restaurantDto.getName() != null) {
                restaurant.setName(restaurantDto.getName());
            }

            if (restaurantDto.getTempName() != null) {
                restaurant.setTempName(restaurantDto.getTempName());
            }

            if (restaurantDto.getTempPhoneNumber() != null) {
                restaurant.setTempPhoneNumber(restaurantDto.getTempPhoneNumber());
            }

            if (restaurantDto.getGender() != null) {
                restaurant.setGender(restaurantDto.getGender());
            }

            if (restaurantDto.getIsMutedGlobalMessages() != null) {
                restaurant.setIsMutedGlobalMessages(restaurantDto.getIsMutedGlobalMessages());
            }

            if (restaurantDto.getKg() != null) {
                restaurant.setKg(restaurantDto.getKg());
            }

            if (restaurantDto.getPhoneNumber() != null) {
                restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
            }
            if (restaurantDto.getPassword() != null) {
                restaurant.setPassword(restaurantDto.getPassword());
            }

            if (restaurantDto.getFakeOrderAttempt() != null) {
                restaurant.setFakeOrderAttempt(restaurantDto.getFakeOrderAttempt());
            }

            if (restaurantDto.getIsHidePhone() != null) {
                restaurant.setIsHidePhone(restaurantDto.getIsHidePhone());
            }

            if (restaurantDto.getLastActiveDate() != null) {
                restaurant.setLastActiveDate(restaurantDto.getLastActiveDate());
            }

            if (restaurantDto.getCreatedDate() != null) {
                restaurant.setCreatedDate(restaurantDto.getCreatedDate());
            }

            if (restaurantDto.getDeviceId() != null) {
                restaurant.setDeviceId(restaurantDto.getDeviceId());
            }

            if (restaurantDto.getIsDisable() != null) {
                restaurant.setIsDisable(restaurantDto.getIsDisable());
            }

            restaurant = restaurantRepository.save(restaurant);
            return modelMapper.map(restaurant, RestaurantDto.class);


        }
        return null;
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Boolean isRestaurantPhoneNumberTaken(String phoneNumber) {
        return restaurantRepository.findRestaurantByPhoneNumber(phoneNumber) != null;
    }

    @Override
    public RestaurantDto findRestaurantByPhoneNumber(String phoneNumber) {
        Restaurant restaurant = restaurantRepository.findRestaurantByPhoneNumber(phoneNumber);
        if (restaurant != null) {
            return modelMapper.map(restaurant, RestaurantDto.class);
        }
        return null;
    }

}
