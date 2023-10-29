package com.example.demo.repository;

import com.example.demo.model.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StaffRepositoryTest {

    @Autowired
    private StaffRepository staffRepo;

    @Test
    public void givenStaff_whenSave_thenReturnSavedStaff() {

        Staff staff = new Staff("John", "Manager");

        Staff savedStaff = staffRepo.save(staff);

        assertThat(savedStaff).isNotNull();
        assertThat(savedStaff.getName()).isEqualTo("John");
    }

    @Test
    public void givenSavedStaff_whenFindById_thenReturnStaff() {

        staffRepo.save(new Staff("Jane", "Waiter"));

        Staff staff = staffRepo.findById(1L).get();

        assertThat(staff).isNotNull();
        assertThat(staff.getName()).isEqualTo("John");
    }

    @Test
    public void givenSavedStaff_whenFindAll_thenReturnStaffList() {

        staffRepo.save(new Staff("John", "Manager"));
        staffRepo.save(new Staff("Jane", "Waiter"));

        List<Staff> staffList = staffRepo.findAll();

        assertThat(staffList).hasSize(11);
    }
}