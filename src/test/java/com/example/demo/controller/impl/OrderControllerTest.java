package com.example.demo.controller.impl;

import com.example.demo.model.MenuItem;
import com.example.demo.model.Orderr;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StaffRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    WebApplicationContext webApplicationContext;


    Orderr order;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        order = new Orderr("hot drink");
    }


    @Test
    void getAllOrders_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/orders/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("cold"));

    }


    @Test
    void updateOrder_validBody() throws Exception {
        order.setStatus("cold");

        order = orderRepository.save(order);

        String body = objectMapper.writeValueAsString(order);

        mockMvc.perform(put("/api/orders/" + order.getId()).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(menuItemRepository.findAll().toString().contains("cold"));
    }


    @Test
    void deleteOrder_validRequest() throws Exception {
        order = orderRepository.save(order);

        mockMvc.perform(delete("/api/orders/" + order.getId()))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(menuItemRepository.findAll().toString().contains("AAA"));
    }
}





