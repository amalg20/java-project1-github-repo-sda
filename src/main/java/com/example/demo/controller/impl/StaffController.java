package com.example.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.model.Staff;

import com.example.demo.service.interfaces.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    //  ****************************************************  POST ****************************************************
    @PostMapping("/")
    public Staff saveStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    //  ****************************************************  GET ****************************************************
    @GetMapping("/")
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable("id") Long id) {
        return staffService.getStaffById(id);
    }

    //  ****************************************************  PUT ****************************************************
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff) {
        return staffService.updateStaffById(id, staff);
    }

    //  ****************************************************  DELETE ****************************************************
    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable("id") Long id) {
        return staffService.deleteStaff(id);
    }
}

