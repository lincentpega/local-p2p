package com.lincentpega.localp2p.paymentmethod.persistence;

import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethodEntity, Long> {
}