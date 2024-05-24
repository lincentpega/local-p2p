package com.lincentpega.localp2p.order.persistence;

import com.lincentpega.localp2p.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}