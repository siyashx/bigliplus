package com.biglikuryer.bigliplus.dto.chat_action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatActionDto {

    private Long id;

    private Long actionId;

    private Long userId;

    private Boolean isCustomer;

    private String message;

    private String time;

    private String date;

}
