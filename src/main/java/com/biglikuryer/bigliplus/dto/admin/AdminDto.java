package com.biglikuryer.bigliplus.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminDto {

    private Long id;

    private String oneSignal;

    private Boolean notificationDisable;

    private Boolean isMutedGlobalMessages;

    private String deviceId;
}
