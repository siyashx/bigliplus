package com.biglikuryer.bigliplus.dao.action;

import com.biglikuryer.bigliplus.model.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}