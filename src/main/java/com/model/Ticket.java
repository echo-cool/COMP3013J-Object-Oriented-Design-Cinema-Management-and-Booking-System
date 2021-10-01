package com.model;

public class Ticket {
    private Integer id;

    private Integer orderID;

    private Integer customerID;

    private Integer arrangemntID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getArrangemntID() {
        return arrangemntID;
    }

    public void setArrangemntID(Integer arrangemntID) {
        this.arrangemntID = arrangemntID;
    }
}