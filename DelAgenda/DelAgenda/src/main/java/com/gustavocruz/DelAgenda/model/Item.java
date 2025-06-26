package com.gustavocruz.DelAgenda.model;

import jakarta.persistence.*;

@Entity
@Table
public class Item {

    @Column
    private String Name;

    @Column
    private boolean Delivered = false;

    @Column
    private int Quantity;

    @ManyToOne
    private Delivery delivery;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isDelivered() {
        return Delivered;
    }

    public void setDelivered(boolean delivered) {
        Delivered = delivered;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
