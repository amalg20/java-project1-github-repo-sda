package com.example.demo.controller.impl;

import com.example.demo.model.Orderr;
import com.example.demo.model.Staff;
import com.example.demo.model.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StaffRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MenuItemControllerTest {

    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    MenuItem menuItem = new MenuItem();

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void getAllMenuItems_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/menu-items/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("coffee"));
    }

    @Test
    void saveMenuItem_validBody() throws Exception {
        menuItem.setName("AAA");

        menuItem = menuItemRepository.save(menuItem);

        String body = objectMapper.writeValueAsString(menuItem);

        mockMvc.perform(post("/api/menu-items/").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertFalse(menuItemRepository.findAll().toString().contains("hot coffee"));
    }

    @Test
    void updateMenuItem_validBody() throws Exception {
        menuItem.setName("AAA");

        menuItem = menuItemRepository.save(menuItem);

        String body = objectMapper.writeValueAsString(menuItem);

        mockMvc.perform(put("/api/menu-items/" + menuItem.getId()).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(menuItemRepository.findAll().toString().contains("hot coffee"));
    }

    @Test
    void deleteMenuItem_validRequest() throws Exception {
        menuItem = menuItemRepository.save(menuItem);

        mockMvc.perform(delete("/api/menu-items/" + menuItem.getId()))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(menuItemRepository.findAll().toString().contains("AAA"));
    }
}