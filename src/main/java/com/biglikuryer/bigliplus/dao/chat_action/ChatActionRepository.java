package com.biglikuryer.bigliplus.dao.chat_action;

import com.biglikuryer.bigliplus.model.chat_action.ChatAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatActionRepository extends JpaRepository<ChatAction, Long> {
}
