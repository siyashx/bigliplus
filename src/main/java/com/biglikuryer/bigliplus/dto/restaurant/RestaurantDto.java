package com.biglikuryer.bigliplus.dto.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RestaurantDto {

    private Long id;

    private String oneSignal;

    private String name;

    private String tempName;

    private String phoneNumber;

    private String password;

    private String createdDate;

    private String deviceId;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
