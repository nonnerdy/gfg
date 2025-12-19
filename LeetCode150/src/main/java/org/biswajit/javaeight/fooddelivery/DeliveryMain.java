package org.biswajit.javaeight.fooddelivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryMain {
    public static void main(String[] args) {
        // 1. Create orders
        Map<String, Order> orders = new HashMap<>();
        orders.put("O1", new Order("O1", "R1"));
        orders.put("O2", new Order("O2", "R1"));
        orders.put("O3", new Order("O3", "R2"));

        // 2. Create status updates (time-ordered, as in your input)
        List<StatusUpdate> updates = List.of(
                new StatusUpdate("O1", OrderStatus.RECEIVED),
                new StatusUpdate("O1", OrderStatus.ACCEPTED),
                new StatusUpdate("O1", OrderStatus.PREPARING),
                new StatusUpdate("O1", OrderStatus.PICKED_UP),
                new StatusUpdate("O1", OrderStatus.DELIVERED),

                new StatusUpdate("O2", OrderStatus.RECEIVED),
                new StatusUpdate("O2", OrderStatus.ACCEPTED),
                new StatusUpdate("O2", OrderStatus.PREPARING),

                new StatusUpdate("O3", OrderStatus.RECEIVED),
                new StatusUpdate("O3", OrderStatus.ACCEPTED),
                new StatusUpdate("O3", OrderStatus.PICKED_UP) // invalid: skipped PREPARING
        );

        // 3. Process updates
        OrderService service = new OrderService();
        for (StatusUpdate u : updates) {
            Order order = orders.get(u.getOrderId());
            if (order == null) {
                continue; // or throw, depending on design
            }
            service.updateStatus(order, u.getNewStatus());
        }

        // 4. Categorize orders

        List<Order> delivered = new ArrayList<>();
        List<Order> inProgress = new ArrayList<>();
        List<Order> invalid = new ArrayList<>();

        for (Order order : orders.values()) {
            if (order.isInvalid()) {
                invalid.add(order);
            } else if (order.getCurrentStatus() == OrderStatus.DELIVERED) {
                delivered.add(order);
            } else if (order.getCurrentStatus() != null) {
                inProgress.add(order);
            }
        }

        // 5. Print results (matches your expected conceptual output)

        System.out.println("Delivered Orders:");
        delivered.forEach(o -> System.out.println("  " + o.getId()));

        System.out.println("\nIn-Progress Orders:");
        inProgress.forEach(o ->
                System.out.println("  " + o.getId() + " -> " + o.getCurrentStatus())
        );

        System.out.println("\nInvalid Orders:");
        invalid.forEach(o ->
                System.out.println("  " + o.getId() + " -> " + o.getInvalidReason())
        );
    }
    }

