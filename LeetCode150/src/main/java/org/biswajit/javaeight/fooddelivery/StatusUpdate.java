package org.biswajit.javaeight.fooddelivery;

public class StatusUpdate {
    private final String orderId;
    private final OrderStatus newStatus;

    public StatusUpdate(String orderId, OrderStatus newStatus) {
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }
}
