package org.biswajit.javaeight.fooddelivery;

import java.util.List;

public class OrderService {

    private static final List<OrderStatus> FLOW = List.of(
            OrderStatus.RECEIVED,
            OrderStatus.ACCEPTED,
            OrderStatus.PREPARING,
            OrderStatus.PICKED_UP,
            OrderStatus.DELIVERED
    );

    public void updateStatus(Order order, OrderStatus newStatus) {
        if (order.isInvalid()) {
            // Already invalid, ignore future updates
            return;
        }

        OrderStatus current = order.getCurrentStatus();

        // First status must be RECEIVED
        if (current == null) {
            if (newStatus != OrderStatus.RECEIVED) {
                order.markInvalid("First status must be RECEIVED, got " + newStatus);
            } else {
                order.applyStatus(newStatus);
            }
            return;
        }

        int currIdx = FLOW.indexOf(current);
        int newIdx = FLOW.indexOf(newStatus);

        // Must strictly move one step forward in the flow
        if (newIdx == currIdx + 1) {
            order.applyStatus(newStatus);
        } else {
            String reason = "Invalid transition " + current + " → " + newStatus;
            order.markInvalid(reason);
        }
    }

}
