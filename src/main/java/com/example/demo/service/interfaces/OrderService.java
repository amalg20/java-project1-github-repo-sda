package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.model.Orderr;


public interface OrderService {
    List<Orderr> getAllOrders();

    Orderr getOrderById(Long id);

    Orderr addOrder(Orderr order);

    Orderr updateOrderById(Long id, Orderr order);

    String deleteOrder(Long id);
}
