package com.lincentpega.localp2p.paymentmethod.mappers;

import com.lincentpega.localp2p.paymentmethod.domain.PaymentMethod;
import com.lincentpega.localp2p.paymentmethod.persistence.PaymentMethodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethod toPaymentMethod(PaymentMethodEntity paymentMethodEntity);
    PaymentMethodEntity toPaymentMethodEntity(PaymentMethod paymentMethod);
}
