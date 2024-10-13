package com.biglikuryer.bigliplus.dto.chat_custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatCustomDto {

    private Long id;

    private Long orderId;

    private Long userId;

    private Long courierId;

    private String message;

    private String time;

    private String date;

}
