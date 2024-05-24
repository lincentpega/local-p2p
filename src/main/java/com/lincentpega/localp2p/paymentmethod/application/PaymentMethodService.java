package com.lincentpega.localp2p.paymentmethod.application;

import com.lincentpega.localp2p.common.exceptions.LogicException;
import com.lincentpega.localp2p.paymentmethod.domain.PaymentMethod;
import com.lincentpega.localp2p.paymentmethod.mappers.PaymentMethodMapper;
import com.lincentpega.localp2p.paymentmethod.persistence.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper mapper;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository,
                                PaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.mapper = paymentMethodMapper;
    }

    public Optional<PaymentMethod> getPaymentMethodById(long id) {
        return paymentMethodRepository.findById(id).map(mapper::toPaymentMethod);
    }

    public Iterable<PaymentMethod> getAllPaymentMethods() {
        return StreamSupport.stream(paymentMethodRepository.findAll().spliterator(), false)
                .map(mapper::toPaymentMethod)
                .toList();
    }

    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethodRepository.existsById(paymentMethod.getId())) {
            throw new LogicException("Payment method with id " + paymentMethod.getId() + " already exists");
        }
        return mapper.toPaymentMethod(paymentMethodRepository.save(mapper.toPaymentMethodEntity(paymentMethod)));
    }

    public void deletePaymentMethodById(long id) {
        paymentMethodRepository.deleteById(id);
    }
}
