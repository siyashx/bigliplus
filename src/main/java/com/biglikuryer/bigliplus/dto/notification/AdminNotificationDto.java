package com.biglikuryer.bigliplus.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminNotificationDto {

    private Long id;

    private String userId;

    private String reportPanel;

    private Boolean isReport;

    private String text;

}