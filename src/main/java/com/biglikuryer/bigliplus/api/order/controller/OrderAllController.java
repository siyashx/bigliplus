package com.biglikuryer.bigliplus.api.order.controller;

import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.service.impl.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3/orders")
public class OrderAllController {
    private final OrderServiceImpl orderServiceImpl;

    public OrderAllController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // List
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(orderDtoList);
    }
}
