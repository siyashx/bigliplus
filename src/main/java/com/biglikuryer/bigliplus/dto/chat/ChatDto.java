package com.biglikuryer.bigliplus.dto.chat;

import jakarta.persistence.Convert;
import kotlin.Pair;
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
    private String username;
    private List<String> isSeenIds;
    private Boolean isForwarded;
    @Convert(converter = ForwardedMessageConverter.class)
    private ForwardedMessage forwardedMessage;
    private String userType;
    private String message;
    private String time;
    private String date;
}