package com.example.demo.controller.impl;

import com.example.demo.model.Orderr;
import com.example.demo.model.Staff;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StaffRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StaffControllerTest {

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

    Staff staff;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        staff = new Staff("Ahmad", "Employee");
    }


    @Test
    void getAllStaffs_validRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/staff/")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ahmad"));

    }

    @Test
    void updateStaff_validBody() throws Exception {
        staff.setName("huda");
        staff = staffRepository.save(staff);

        String body = objectMapper.writeValueAsString(staff);

        mockMvc.perform(put("/api/staff/" + staff.getId()).content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        assertFalse(menuItemRepository.findAll().toString().contains("huda"));
    }

    @Test
    void deleteStaff_validRequest() throws Exception {
        staff = staffRepository.save(staff);

        mockMvc.perform(delete("/api/staff/" + staff.getId())).andExpect(status().isOk()).andReturn();

        assertTrue(menuItemRepository.findAll().toString().contains("AAA"));
    }
}
