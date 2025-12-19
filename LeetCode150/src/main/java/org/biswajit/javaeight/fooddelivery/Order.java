package org.biswajit.javaeight.fooddelivery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String id;
    private  String restaurant;
    private OrderStatus currentStatus;
    private final List<OrderStatus> history = new ArrayList<>();
    private boolean invalid;
    private String invalidReason;


    public Order(String id, String restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }
    public String getId() {
        return id;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public String getInvalidReason() {
        return invalidReason;
    }

    public List<OrderStatus> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void markInvalid(String reason) {
        if (!this.invalid) {       // keep first invalid reason
            this.invalid = true;
            this.invalidReason = reason;
        }
    }

    public void applyStatus(OrderStatus newStatus) {
        this.currentStatus = newStatus;
        this.history.add(newStatus);
    }

}
