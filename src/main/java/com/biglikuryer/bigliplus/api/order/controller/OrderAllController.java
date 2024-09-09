package com.biglikuryer.bigliplus.api.order.controller;

import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.service.impl.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v3")
public class OrderAllController {
    private final OrderServiceImpl orderServiceImpl;


    public OrderAllController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // WebSocket ile istekleri işlemek için metot
    @MessageMapping("/getOrders")
    @SendTo("/topic/orders")
    public List<OrderDto> getAllOrdersViaWebSocket() {
        return orderServiceImpl.getAllOrders();
    }

    // HTTP GET isteği ile istekleri işlemek için metot
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrdersViaHttp() {
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(orderDtoList);
    }
}
