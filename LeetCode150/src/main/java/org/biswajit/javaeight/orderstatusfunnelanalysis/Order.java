package org.biswajit.javaeight.orderstatusfunnelanalysis;

public class Order {
    private String orderId;
    private OrderStatus order;

    public Order(String orderId, OrderStatus order) {
        this.orderId = orderId;
        this.order = order;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrder() {
        return order;
    }

    public void setOrder(OrderStatus order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", order=" + order +
                '}';
    }
}
