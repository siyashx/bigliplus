package com.biglikuryer.bigliplus.service.impl.order;

import com.biglikuryer.bigliplus.dao.order.OrderRepository;
import com.biglikuryer.bigliplus.dto.order.OrderDto;
import com.biglikuryer.bigliplus.model.order.Order;
import com.biglikuryer.bigliplus.service.inter.order.OrderServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderServiceInter {


    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order = orderRepository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.map(order -> modelMapper.map(order, OrderDto.class)).orElse(null);
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            if (orderDto.getCourierId() != null) {
                order.setCourierId(orderDto.getCourierId());
            }

            if (orderDto.getRestaurantId() != null) {
                order.setRestaurantId(orderDto.getRestaurantId());
            }

            if (orderDto.getStatus() != null) {
                order.setStatus(orderDto.getStatus());
            }

            if (orderDto.getCustomerPhoneNumber() != null) {
                order.setCustomerPhoneNumber(orderDto.getCustomerPhoneNumber());
            }

            if (orderDto.getPickupLocation() != null) {
                order.setPickupLocation(orderDto.getPickupLocation());
            }

            if (orderDto.getToLocation() != null) {
                order.setToLocation(orderDto.getToLocation());
            }

            if (orderDto.getPickupLocationLatLong() != null) {
                order.setPickupLocationLatLong(orderDto.getPickupLocationLatLong());
            }

            if (orderDto.getOrderType() != null) {
                order.setOrderType(orderDto.getOrderType());
            }

            if (orderDto.getCancelledCouriers() != null) {
                order.setCancelledCouriers(orderDto.getCancelledCouriers());
            }

            if (orderDto.getCancelledDescription() != null) {
                order.setCancelledDescription(orderDto.getCancelledDescription());
            }

            if (orderDto.getOrderLock() != null) {
                order.setOrderLock(orderDto.getOrderLock());
            }

            if (orderDto.getToLocationLatLong() != null) {
                order.setToLocationLatLong(orderDto.getToLocationLatLong());
            }

            if (orderDto.getDeliveryLength() != null) {
                order.setDeliveryLength(orderDto.getDeliveryLength());
            }

            if (orderDto.getDeliveryTime() != null) {
                order.setDeliveryTime(orderDto.getDeliveryTime());
            }

            if (orderDto.getDescription() != null) {
                order.setDescription(orderDto.getDescription());
            }

            if (orderDto.getPrice() != null) {
                order.setPrice(orderDto.getPrice());
            }

            if (orderDto.getCreatedDate() != null) {
                order.setCreatedDate(orderDto.getCreatedDate());
            }

            if (orderDto.getCreatedTime() != null) {
                order.setCreatedTime(orderDto.getCreatedTime());
            }

            order = orderRepository.save(order);
            return modelMapper.map(order, OrderDto.class);


        }
        return null;
    }

    @Override
    public Boolean removeById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderRepository.delete(order);
            return true;
        }
        return false;
    }
}
