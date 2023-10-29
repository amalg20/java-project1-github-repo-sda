package com.example.demo.controller.interfaces;

import com.example.demo.model.Staff;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IStaffController {

    public Staff saveStaff(Staff staff);

    public List<Staff> getAllStaff();

    public Staff getStaffById(Long id);

    public Staff updateStaff(Long id, Staff staff);

    public String deleteStaff(Long id);
}



