package com.biglikuryer.bigliplus.model.courier;

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
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oneSignal;

    private String name;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    private String motoPhoto;

    private String motoDescription;

    @Column(nullable = false)
    private String password;

    private String latLong;

    private Boolean currentlyDelivery;

    private String map;

    private Boolean online;

    private String createdDate;

    private Boolean registerRequest;

    private String deviceId;

    @JsonProperty("isDisable")
    private Boolean isDisable;
}
