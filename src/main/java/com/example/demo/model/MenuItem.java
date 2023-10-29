package com.example.demo.model;

import jakarta.persistence.*;

@Entity

public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private double price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "orderr_id")
    private Orderr handledByOrder;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff createdByStaff;

    public MenuItem() {
    }

    public MenuItem(String name, double price, String description, Orderr handledByOrder, Staff createdByStaff) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.handledByOrder = handledByOrder;
        this.createdByStaff = createdByStaff;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Orderr getHandledByOrder() {
        return handledByOrder;
    }

    public void setHandledByOrder(Orderr handledByOrder) {
        this.handledByOrder = handledByOrder;
    }

    public Staff getCreatedByStaff() {
        return createdByStaff;
    }

    public void setCreatedByStaff(Staff createdByStaff) {
        this.createdByStaff = createdByStaff;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "name='" + name + '\'' + ", price=" + price + ", description='" + description + '\'' + ", handledByOrder=" + handledByOrder + ", createdByStaff=" + createdByStaff + '}';
    }
}
