package com.biglikuryer.bigliplus.task;

import com.biglikuryer.bigliplus.dao.courier.CourierRepository;
import com.biglikuryer.bigliplus.model.courier.Courier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class CourierOrderCleanupTask {

    private final CourierRepository courierRepository;

    public CourierOrderCleanupTask(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Scheduled(fixedRate = 300000) // 5 dakika (300000 ms)
    public void updateOfflineCouriers() {
        // Azerbaycan Bakü'nün saat dilimini belirt
        ZoneId zoneId = ZoneId.of("Asia/Baku");
        // Azerbaycan Bakü saatiyle şu anki zamanı al
        LocalDateTime now = LocalDateTime.now(zoneId);
        // 5 dakika öncesinin zamanını al
        LocalDateTime threshold = now.minusMinutes(5);

        // threshold string'i oluştur
        String thresholdString = threshold.format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"));

        // currentlyDelivery özelliği false olan ve lastActiveDate'i belirli bir zamanı geçmiş kuryeleri al
        List<Courier> offlineCouriers = courierRepository.findByCurrentlyDeliveryFalseAndLastActiveDateNotNullAndLastActiveDateBefore(thresholdString);

        // Alınan kuryelerin online durumunu güncelle
        for (Courier courier : offlineCouriers) {
            courier.setOnline(false);
            courierRepository.save(courier);
        }
    }
}