package com.lincentpega.localp2p.paymentmethod.api;

import com.lincentpega.localp2p.paymentmethod.application.PaymentMethodService;
import com.lincentpega.localp2p.paymentmethod.domain.PaymentMethod;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.*;

@RestController
@RequestMapping("/api/admin/payment-method")
public class PaymentMethodAdminController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodAdminController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public ResponseEntity<?> getPaymentMethods() {
        return ResponseEntity.ok(paymentMethodService.getAllPaymentMethods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentMethodInfo(@PathVariable long id) {
        Optional<PaymentMethod> paymentMethod = paymentMethodService.getPaymentMethodById(id);
        return paymentMethod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPaymentMethod(@Valid @RequestBody CreatePaymentMethodRequest request) {
        PaymentMethod paymentMethod = paymentMethodService.savePaymentMethod(new PaymentMethod(request.name()));
        return ResponseEntity.created(getResourceURI(paymentMethod)).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaymentMethod(@PathVariable long id) {
        paymentMethodService.deletePaymentMethodById(id);
        return ResponseEntity.noContent().build();
    }

    public static URI getResourceURI(PaymentMethod savedPaymentMethod) {
        return fromMethodCall(on(PaymentMethodAdminController.class).getPaymentMethodInfo(savedPaymentMethod.getId()))
                .build()
                .toUri();
    }
}
