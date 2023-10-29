package com.example.demo.repository;

import com.example.demo.model.Orderr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryIntegrationTests {

    @Autowired
    private OrderRepository orderRepo;

    @Test
    void givenOrder_whenSave_thenReturnSavedOrder() {

        Orderr order = new Orderr("PENDING");

        Orderr savedOrder = orderRepo.save(order);

        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getStatus()).isEqualTo("PENDING");
    }

    @Test
    void givenSavedOrder_whenFindById_thenReturnOrder() {

        orderRepo.save(new Orderr("PENDING"));

        Orderr fetchedOrder = orderRepo.findById(1L).get();

        assertThat(fetchedOrder).isNotNull();
        assertThat(fetchedOrder.getStatus()).isEqualTo("COMPLETED");
    }

    @Test
    void givenSavedOrders_whenFindAll_thenReturnOrderList() {

        orderRepo.save(new Orderr("PENDING"));
        orderRepo.save(new Orderr("COMPLETED"));

        List<Orderr> orderList = orderRepo.findAll();

        assertThat(orderList).hasSize(44);

    }

    @Test
    void givenSavedOrder_whenUpdateStatus_thenOrderShouldBeUpdated() {

        Orderr savedOrder = orderRepo.save(new Orderr("PENDING"));

        savedOrder.setStatus("COMPLETED");
        orderRepo.save(savedOrder);

        Orderr updatedOrder = orderRepo.findById(savedOrder.getId()).get();

        assertThat(updatedOrder.getStatus()).isEqualTo("COMPLETED");
    }

    @Test
    void givenSavedOrder_whenDeleteById_thenOrderShouldBeDeleted() {

        Orderr savedOrder = orderRepo.save(new Orderr("PENDING"));

        orderRepo.deleteById(savedOrder.getId());

        Orderr deletedOrder = orderRepo.findById(savedOrder.getId()).orElse(null);

        assertThat(deletedOrder).isNull();
    }

}