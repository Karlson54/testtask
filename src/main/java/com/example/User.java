package com.example;

class User {
    private OrderHistory orderHistory;

    public User() {
        this.orderHistory = new OrderHistory();
    }

    public void addOrder(Order order) {
        orderHistory.addOrder(order);
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }
}