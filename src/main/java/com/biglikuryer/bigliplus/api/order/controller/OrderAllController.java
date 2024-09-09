package com.biglikuryer.bigliplus.api.order.controller;

import com.biglikuryer.bigliplus.dto.chat.ChatDto;
import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.service.impl.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v3")
public class OrderAllController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // WebSocket ile istekleri işlemek için metot
    @MessageMapping("/getOrders")
    public void getAllOrdersViaWebSocket() {
        List<OrderDto> orders = orderServiceImpl.getAllOrders();
        messagingTemplate.convertAndSend("/topic/orders", orders);
    }

    // HTTP GET isteği ile istekleri işlemek için metot
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrdersViaHttp() {
        List<OrderDto> orderDtoList = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(orderDtoList);
    }
}
