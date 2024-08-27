package com.biglikuryer.bigliplus.chat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
