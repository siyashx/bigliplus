package com.biglikuryer.bigliplus.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version; // Optimistic locking

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "courier_id")
    private Long courierId;

    private String status;

    private String pickupLocation;

    private String toLocation;

    private String pickupLocationLatLong;

    private String toLocationLatLong;

    private String deliveryLength;

    private String description;

    private Double price;

    private String createdDate;

    private String createdTime;


}
