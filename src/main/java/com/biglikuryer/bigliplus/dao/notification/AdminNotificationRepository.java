package com.biglikuryer.bigliplus.dao.notification;


import com.biglikuryer.bigliplus.model.notification.AdminNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminNotificationRepository extends JpaRepository<AdminNotification, Long> {
}
