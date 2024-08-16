package com.biglikuryer.bigliplus.model.advert;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "adverts")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String mode;

    private String premiumExpiredDate;

    private Boolean haveWhatsapp;

    private Boolean haveHelmet;

    private String description;

    private Integer viewCount;

    private String createdDate;

}
