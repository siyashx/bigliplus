package com.biglikuryer.bigliplus.model.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oneSignal;

    private String name;

    private String gender;

    private String tempName;

    private String tempPhoneNumber;

    private Boolean isMutedGlobalMessages;

    private Integer kg;

    private Boolean isHidePhone;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    private Boolean fakeOrderAttempt;

    private String lastActiveDate;

    private String createdDate;

    private String deviceId;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
