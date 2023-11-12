package com.biglikuryer.bigliplus.service.inter.restaurant;

import com.biglikuryer.bigliplus.dto.restaurant.RestaurantDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantServiceInter {

    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantById(Long id);
    ResponseEntity<RestaurantDto> createRestaurant(RestaurantDto restaurantDto);
    RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDto);
    void deleteRestaurantById(Long id);
    Boolean isRestaurantPhoneNumberTaken(String phoneNumber);
    RestaurantDto findRestaurantByPhoneNumber(String phoneNumber);
}
