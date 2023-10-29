package com.example.demo.model;

import jakarta.persistence.*;


@Entity

public class Staff {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "staff_name")
    private String name;

    @Column(name = "staff_role")
    private String role;


    public Staff() {
    }

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
