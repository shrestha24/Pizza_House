package com.example.pizza_house.Model;

public class Bill {
    Order order;
    String name;
    String address;
    String landmarks;
    String zip;

    public Bill(Order order, String name, String address, String landmarks, String zip) {
        this.order = order;
        this.name = name;
        this.address = address;
        this.landmarks = landmarks;
        this.zip = zip;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(String landmarks) {
        this.landmarks = landmarks;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
