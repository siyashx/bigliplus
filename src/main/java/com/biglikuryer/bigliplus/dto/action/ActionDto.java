package com.biglikuryer.bigliplus.dto.action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ActionDto {

    private Long id;

    private Long mainUserId;

    private Boolean createdByCustomer;

    private Boolean isDisAllowedCustomerJoin;

    private String subCustomersId;

    private String subCouriersId;

    private String pickupLocationTitle;

    private String pickupLocation;

    private Integer maxSubSize;

    private String toLocationTitle;

    private String pickupTime;

    private String pickupDate;

    private String status;

    private String description;

    private String createdDate;


}
