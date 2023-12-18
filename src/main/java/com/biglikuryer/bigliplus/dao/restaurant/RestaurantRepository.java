package com.biglikuryer.bigliplus.dao.restaurant;

import com.biglikuryer.bigliplus.model.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findRestaurantByPhoneNumber(String phoneNumber);
}
