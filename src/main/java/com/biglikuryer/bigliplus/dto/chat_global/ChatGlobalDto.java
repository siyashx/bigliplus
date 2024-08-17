package com.biglikuryer.bigliplus.dto.chat_global;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatGlobalDto {

    private Long id;

    private Long userId;

    private String isSeenId;
    
    private Boolean isForwarded;

    private String forwardedId;

    private Boolean isCustomer;

    private String message;

    private String time;

    private String date;

}
