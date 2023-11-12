package com.biglikuryer.bigliplus.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDto {

    private Long id;

    private Long restaurantId;

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
