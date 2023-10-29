package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.interfaces.StaffService;


@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepo;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepo.findById(id).orElse(null);
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public Staff updateStaffById(Long id, Staff staff) {
        staffRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        staff.setId(id);

        return staffRepo.save(staff);
    }

    @Override
    public String deleteStaff(Long id) {

        if (staffRepo.findById(id).isPresent()) {
            staffRepo.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }
}

