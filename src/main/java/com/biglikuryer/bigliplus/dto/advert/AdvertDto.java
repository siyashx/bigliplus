package com.biglikuryer.bigliplus.dto.advert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdvertDto {

    private Long id;

    private Long userId;

    private String mode;

    private String premiumDate;

    private Boolean haveWhatsapp;

    private Boolean haveHelmet;

    private String description;

    private Integer viewCount;

    private String createdDate;


}
