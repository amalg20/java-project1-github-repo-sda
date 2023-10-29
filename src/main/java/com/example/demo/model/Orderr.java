package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity

public class Orderr {

    @Id
    @GeneratedValue
    private Long id;


    private String status;

//    @Embedded
//    private Staff staff;

    public Orderr() {
    }

    public Orderr(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                '}';
    }
}
