package com.biglikuryer.bigliplus.model.chat;

import com.biglikuryer.bigliplus.dto.chat.ForwardedMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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

    private String username;

    private ForwardedMessage forwardedMessage;

    private List<String> isSeenIds;

    private Boolean isForwarded;
    private String userType;
    private String message;
    private String time;
    private String date;
}
