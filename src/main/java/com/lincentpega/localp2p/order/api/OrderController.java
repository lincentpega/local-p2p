package com.lincentpega.localp2p.order.api;

import com.lincentpega.localp2p.order.application.OrderService;
import com.lincentpega.localp2p.order.application.usecase.createorder.CreateOrderCommand;
import com.lincentpega.localp2p.order.application.usecase.createorder.CreateOrderUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/order")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public createOrder(CreateOrderRequest request) {
        createOrderUseCase.handle(new CreateOrderCommand(request.getUsername()));

    }

}
