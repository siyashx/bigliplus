package com.biglikuryer.bigliplus.dao.order;

import com.biglikuryer.bigliplus.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
