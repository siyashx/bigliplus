package com.biglikuryer.bigliplus.service.inter.order;

import com.biglikuryer.bigliplus.dto.order.OrderDto;

import java.util.List;

public interface OrderServiceInter {

    OrderDto createOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    Boolean removeById(Long orderId);

    OrderDto getOrderById(Long orderId);

    OrderDto updateOrder(Long orderId, OrderDto orderDto);
}
