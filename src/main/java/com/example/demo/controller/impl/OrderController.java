package com.example.demo.controller.impl;

import com.example.demo.model.Orderr;
import com.example.demo.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //  ****************************************************  POST  ****************************************************
    @PostMapping("/")
    public Orderr saveOrder(@RequestBody Orderr order) {
        return orderService.addOrder(order);
    }

    //  ****************************************************  GET  ****************************************************
    @GetMapping("/")
    public List<Orderr> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orderr getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    //  ****************************************************  PUT  ****************************************************
    @PutMapping("/{id}")
    public Orderr updateOrder(@PathVariable("id") Long id, @RequestBody Orderr order) {
        return orderService.updateOrderById(id, order);
    }

    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        return orderService.deleteOrder(id);
    }
}


