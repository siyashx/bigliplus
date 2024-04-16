package com.biglikuryer.bigliplus.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String orderType;

    private String cancelledCouriers;

    private String cancelledDescription;

    private String customerPhoneNumber;

    private String pickupLocationTitle;

    private String pickupLocation;

    private String toLocationTitle;

    private String toLocation;

    private String deliveryLength;

    private String deliveryTime;

    private String walkTime;

    private String needCourierPrice;

    private Double price;

    private String createdDate;

    private String createdTime;

    @JsonProperty("isDisable")
    private String isDisable;
}
