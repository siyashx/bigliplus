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

    private String gender;

    private String tempName;

    private String tempPhoneNumber;

    private Boolean isMutedGlobalMessages;

    private Integer kg;

    private Boolean isHidePhone;

    private String phoneNumber;

    private String password;

    private Boolean fakeOrderAttempt;

    private String createdDate;

    private String lastActiveDate;

    private String deviceId;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
