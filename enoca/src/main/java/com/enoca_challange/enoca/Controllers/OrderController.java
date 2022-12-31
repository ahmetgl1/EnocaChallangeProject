package com.enoca_challange.enoca.Controllers;

import com.enoca_challange.enoca.Dto.OrderRequest;
import com.enoca_challange.enoca.Entities.Order;
import com.enoca_challange.enoca.Services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enoca")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public ResponseEntity<Order> putAnOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.putAnOrder(orderRequest.getUserName() , orderRequest.getBookIdList()));
    }







}
