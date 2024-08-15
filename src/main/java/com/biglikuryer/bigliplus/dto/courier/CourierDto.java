package com.biglikuryer.bigliplus.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourierDto {

    private Long id;

    private String oneSignal;

    private String name;

    private String phoneNumber;

    private String motoPhoto;

    private String motoDescription;

    private String rating;

    private String ratedCustomers;

    private String ratedPoints;

    private String workType;

    private Boolean isActiveWorkTypeRequest;

    private Boolean isAllowedEconomOrders;

    private String password;

    private String latLong;

    private String radius;

    private Boolean currentlyDelivery;

    private String map;

    private Boolean online;

    private String createdDate;

    private String deviceId;

    private String lastActiveDate;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
