package com.biglikuryer.bigliplus.model.chat;

import com.biglikuryer.bigliplus.dto.chat.ForwardedMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
