package com.biglikuryer.bigliplus.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatDto {

    private Long id;
    private Long userId;
    private HashMap<String, Long> isSeenIds;
    private Boolean isForwarded;
    private ForwardedMessage forwardedMessage;
    private String userType;
    private String message;
    private String time;
    private String date;
}