package com.biglikuryer.bigliplus.model.chat;

import com.biglikuryer.bigliplus.dto.chat.ForwardedMessage;
import com.biglikuryer.bigliplus.dto.chat.ForwardedMessageConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Convert(converter = ForwardedMessageConverter.class)
    @Column(name = "forwarded_message", columnDefinition = "TEXT")
    private ForwardedMessage forwardedMessage;

    @ElementCollection
    @CollectionTable(name = "is_seen_ids", joinColumns = @JoinColumn(name = "chat_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, Long> isSeenIds;

    private Boolean isForwarded;
    private String userType;
    private String message;
    private String time;
    private String date;
}
