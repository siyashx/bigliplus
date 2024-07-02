package com.biglikuryer.bigliplus.dao.courier;

import com.biglikuryer.bigliplus.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    Courier findCourierByPhoneNumber(String phoneNumber);
}
