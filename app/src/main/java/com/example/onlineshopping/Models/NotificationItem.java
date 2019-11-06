package com.example.onlineshopping.Models;

public class NotificationItem {
    private String orderNumber;
    private String time;
    private String status;

    public NotificationItem(String orderNumber, String time, String status) {
        this.orderNumber = orderNumber;
        this.time = time;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
