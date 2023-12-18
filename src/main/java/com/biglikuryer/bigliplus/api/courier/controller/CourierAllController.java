package com.biglikuryer.bigliplus.api.courier.controller;

import com.biglikuryer.bigliplus.dto.courier.CourierDto;
import com.biglikuryer.bigliplus.service.impl.courier.CourierServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/couriers")
public class CourierAllController {
    private final CourierServiceImpl courierServiceImpl;

    public CourierAllController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    // List
    @GetMapping
    public List<CourierDto> getAllCouriers() {
        return courierServiceImpl.getAllCouriers();
    }
}
