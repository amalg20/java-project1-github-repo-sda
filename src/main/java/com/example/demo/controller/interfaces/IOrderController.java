package com.example.demo.controller.interfaces;

import com.example.demo.model.Orderr;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IOrderController {

    public Orderr saveOrder(Orderr order);

    public List<Orderr> getAllOrders();

    public Orderr getOrderById(Long id);

    public Orderr updateOrder(Long id, Orderr order);

    public String deleteOrder(Long id);
}
