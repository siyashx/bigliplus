package com.biglikuryer.bigliplus.model.chat_action;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long actionId;

    private Long userId;

    private Boolean isCustomer;

    private String message;

    private String time;

    private String date;

}
