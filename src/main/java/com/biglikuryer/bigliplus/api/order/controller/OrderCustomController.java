package com.biglikuryer.bigliplus.api.order.controller;

import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.service.impl.order.OrderServiceImpl;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/order")
public class OrderCustomController {
    private final OrderServiceImpl orderServiceImpl;

    public OrderCustomController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // Id
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderServiceImpl.getOrderById(orderId);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        }
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(
            @PathVariable Long orderId,
            @RequestBody OrderDto orderDto) {

        try {
            OrderDto updatedOrder = orderServiceImpl.updateOrder(orderId, orderDto);
            if (updatedOrder != null) {
                return ResponseEntity.ok(updatedOrder);
            }
            return ResponseEntity.notFound().build();
        } catch (OptimisticLockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Order has been modified by another user. Please try again.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        boolean deleted = orderServiceImpl.removeById(orderId);
        if (deleted) {
            return ResponseEntity.ok("Order deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
