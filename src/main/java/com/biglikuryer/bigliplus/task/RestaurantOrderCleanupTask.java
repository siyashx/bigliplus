package com.biglikuryer.bigliplus.task;

import com.biglikuryer.bigliplus.dao.order.OrderRepository;
import com.biglikuryer.bigliplus.dao.restaurant.RestaurantRepository;
import com.biglikuryer.bigliplus.model.order.Order;
import com.biglikuryer.bigliplus.model.restaurant.Restaurant;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class RestaurantOrderCleanupTask {

    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;

    public RestaurantOrderCleanupTask(RestaurantRepository restaurantRepository, OrderRepository orderRepository) {
        this.restaurantRepository = restaurantRepository;
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedRate = 300000) // 5 dakika (300000 ms)
    public void disableOrdersForInactiveRestaurants() {
        // Azerbaycan Bakü'nün saat dilimini belirt
        ZoneId zoneId = ZoneId.of("Asia/Baku");
        // Azerbaycan Bakü saatiyle şu anki zamanı al
        LocalDateTime now = LocalDateTime.now(zoneId);
        // 5 dakika öncesinin zamanını al
        LocalDateTime threshold = now.minusMinutes(5);

        // Tüm restoranları al
        List<Restaurant> restaurants = restaurantRepository.findAll();

        // Her restoran için kontrol yap
        for (Restaurant restaurant : restaurants) {
            String lastActiveDateString = restaurant.getLastActiveDate();
            // LastActiveDate null değilse işlem yap
            if (lastActiveDateString != null) {
                // String'i LocalDateTime'a dönüştür
                LocalDateTime lastActiveDate = LocalDateTime.parse(lastActiveDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));

                // LastActiveDate 5 dakikadan daha eskiyse, restoranı devre dışı bırak
                if (lastActiveDate.isBefore(threshold)) {
                    // Restoranın tüm order'larını al
                    List<Order> orders = orderRepository.findByIsDisableFalseAndRestaurantId(restaurant.getId());

                    // Her order'ı devre dışı bırak
                    for (Order order : orders) {
                        order.setIsDisable(true);
                        orderRepository.save(order);
                    }
                }
            }
        }

    }
}
