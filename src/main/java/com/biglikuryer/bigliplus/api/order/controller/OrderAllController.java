package com.biglikuryer.bigliplus.api.order.controller;

import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.service.impl.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class OrderAllController {
    private final OrderServiceImpl orderServiceImpl;


    public OrderAllController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @MessageMapping("/getOrders")
    @SendTo("/topic/orders")
    public List<OrderDto> getAllOrders() {
        return orderServiceImpl.getAllOrders();
    }
}
