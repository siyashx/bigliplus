package com.biglikuryer.bigliplus.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatDto {

    private Long id;
    private Long userId;
    private String isSeenId;
    private Boolean isForwarded;
    private String forwardedId;
    private Boolean isCustomer;
    private Boolean isAdmin;
    private String message;
    private String time;
    private String date;
}
