package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


import com.example.demo.model.Orderr;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public List<Orderr> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Orderr getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public Orderr addOrder(Orderr order) {
        return orderRepo.save(order);
    }

    @Override
    public Orderr updateOrderById(Long id, Orderr order) {
        orderRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        order.setId(id);

        return orderRepo.save(order);
    }

    @Override
    public String deleteOrder(Long id) {

        if (orderRepo.findById(id).isPresent()) {
            orderRepo.deleteById(id);
            return "Order deleted successfully";
        }
        return "No such Order in the database";
    }
}

