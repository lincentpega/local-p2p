package com.lincentpega.localp2p.order.mappers;

import com.lincentpega.localp2p.asset.mappers.AssetMapper;
import com.lincentpega.localp2p.order.domain.Order;
import com.lincentpega.localp2p.order.persistence.OrderEntity;
import com.lincentpega.localp2p.paymentmethod.mappers.PaymentMethodMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AssetMapper.class, PaymentMethodMapper.class})
public interface OrderMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity entity);
}
