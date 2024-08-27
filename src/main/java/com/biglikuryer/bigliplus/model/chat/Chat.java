package com.biglikuryer.bigliplus.model.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String isSeenId;
    private Boolean isForwarded;
    private String forwardedId;
    private Boolean isCustomer;
    private Boolean isAdmin;
    private String message;
    private String time;
    private String date;
}
