package com.biglikuryer.bigliplus.dto.chat;

import lombok.Data;

@Data
public class ForwardedMessage {
    private Long userId;
    private String userType;
    private String message;
}
