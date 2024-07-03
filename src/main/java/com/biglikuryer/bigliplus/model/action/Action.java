package com.biglikuryer.bigliplus.model.action;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "actions")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version; // Optimistic locking

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
