package com.biglikuryer.bigliplus.dao.chat;

import com.biglikuryer.bigliplus.model.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
