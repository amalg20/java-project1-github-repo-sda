package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.model.Staff;


public interface StaffService {

    List<Staff> getAllStaff();

    Staff getStaffById(Long id);

    Staff createStaff(Staff staff);

    Staff updateStaffById(Long id, Staff staff);

    String deleteStaff(Long id);
}


