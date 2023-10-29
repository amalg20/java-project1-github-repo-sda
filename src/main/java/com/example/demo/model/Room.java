package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Room extends Staff {

    private Integer num;
    private String reservation;

    public Room() {
    }

    public Room(Integer num, String reservation) {
        this.num = num;
        this.reservation = reservation;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Room{" +
                "num=" + num +
                ", reservation='" + reservation + '\'' +
                '}';
    }
}
