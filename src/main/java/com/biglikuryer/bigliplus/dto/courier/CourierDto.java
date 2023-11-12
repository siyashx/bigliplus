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

    private String password;

    private String latLong;

    private Boolean currentlyDelivery;

    private Boolean online;

    private String createdDate;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
