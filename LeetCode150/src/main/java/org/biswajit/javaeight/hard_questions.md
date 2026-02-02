# Hard Java Streams – Real World Problems (With Input & Expected Output)

This file contains **10 hard, real-world Java Streams problems** suitable for **senior-level interviews**.  
Each problem includes:
- Scenario
- Task
- **Input data set (sample data)**
- **Expected output data**

---

## 1. E-Commerce Order Revenue with Partial Refunds

### Scenario
Customers can place multiple orders. Each order may contain multiple payments and refunds.

### Task
Calculate **net revenue per customer**:

```
net revenue = total payments − total refunds
```

Exclude customers whose net revenue is **≤ 0**.

### Input Data
```java
orders = List.of(
    new Order("O1", "C1",
        List.of(new Payment(500), new Payment(300)),
        List.of(new Refund(200))
    ),
    new Order("O2", "C1",
        List.of(new Payment(400)),
        List.of()
    ),
    new Order("O3", "C2",
        List.of(new Payment(600)),
        List.of(new Refund(700))
    )
);
```

### Expected Output
```java
{
  "C1" = 1000.0
}
```

---

## 2. Suspicious User Detection Based on Transaction Pattern

### Task
A user is suspicious if:
- At least **3 transactions**
- **Total amount > 100000**
- All transactions within **10 minutes**

### Input Data
```java
transactions = List.of(
    new Transaction("U1", 1000, 40000),
    new Transaction("U1", 1200, 35000),
    new Transaction("U1", 1500, 30000),
    new Transaction("U2", 2000, 60000),
    new Transaction("U2", 4000, 50000)
);
```

### Expected Output
```java
["U1"]
```

---

## 3. Inventory Shortage Detection Across Warehouses

### Task
Identify products where **total available stock < minimum required stock**.
Return warehouse-wise stock for such products.

### Input Data
```java
minimumRequired = Map.of(
    "P1", 100,
    "P2", 200
);

inventories = List.of(
    new Inventory("P1", "W1", 30),
    new Inventory("P1", "W2", 40),
    new Inventory("P2", "W1", 150),
    new Inventory("P2", "W2", 70)
);
```

### Expected Output
```java
{
  "P1" = { "W1" = 30, "W2" = 40 }
}
```

---

## 4. Employee Workload Anomaly Detection

### Task
Find employees who:
- Worked **more than 12 hours in a single day**
- Worked on **multiple projects** that day

### Input Data
```java
logs = List.of(
    new WorkLog("E1", "P1", 2024-01-10, 6),
    new WorkLog("E1", "P2", 2024-01-10, 7),
    new WorkLog("E2", "P1", 2024-01-10, 10)
);
```

### Expected Output
```java
["E1"]
```

---

## 5. Most Frequently Abandoned Cart Products

### Task
Find the **top 3 most frequently abandoned products**.
A product is abandoned if it was added to cart but **never purchased by the same user**.

### Input Data
```java
events = List.of(
    new CartEvent("U1", "P1", false),
    new CartEvent("U1", "P2", true),
    new CartEvent("U2", "P1", false),
    new CartEvent("U3", "P1", false),
    new CartEvent("U3", "P3", false)
);
```

### Expected Output
```java
["P1", "P3"]
```

---

## 6. SLA Breach Analysis in Microservices

### Task
For each service, calculate the **percentage of SLA breaches**.
Return only services where breach percentage is **> 5%**.

### Input Data
```java
logs = List.of(
    new ApiLog("OrderService", 300, 200),
    new ApiLog("OrderService", 180, 200),
    new ApiLog("PaymentService", 100, 200),
    new ApiLog("PaymentService", 220, 200)
);
```

### Expected Output
```java
{
  "OrderService" = 50.0,
  "PaymentService" = 50.0
}
```

---

## 7. Duplicate Payment Detection Using Composite Keys

### Task
Detect duplicate payments where:
- Same userId
- Same amount
- Occurred within **2 minutes**

### Input Data
```java
payments = List.of(
    new Payment("P1", "U1", 500, 1000),
    new Payment("P2", "U1", 500, 1100),
    new Payment("P3", "U2", 700, 2000)
);
```

### Expected Output
```java
[
  [P1, P2]
]
```

---

## 8. Category → Brand → Average Rating

### Task
Calculate **average rating** grouped by category and brand.
Exclude brands with **fewer than 5 reviews**.

### Input Data
```java
reviews = List.of(
    new Review("Electronics", "Sony", 5),
    new Review("Electronics", "Sony", 4),
    new Review("Electronics", "Sony", 5),
    new Review("Electronics", "Sony", 4),
    new Review("Electronics", "Sony", 5),
    new Review("Electronics", "LG", 4)
);
```

### Expected Output
```java
{
  "Electronics" = {
      "Sony" = 4.6
  }
}
```

---

## 9. Real-Time Leaderboard with Time Decay

### Task
Calculate final score per player using decay:

```
finalScore = Σ(score × e^(-hoursSinceEvent))
```

### Input Data
```java
events = List.of(
    new GameEvent("Player1", 100, now - 1h),
    new GameEvent("Player1", 50, now - 3h),
    new GameEvent("Player2", 120, now - 1h)
);
```

### Expected Output
```java
{
  "Player1" ≈ 92.4,
  "Player2" ≈ 44.1
}
```

---

## 10. Order Fulfillment Bottleneck Detection

### Task
Identify orders where the time gap between **any two consecutive stages exceeds 48 hours**.

Stages:
```
PLACED → PACKED → SHIPPED → DELIVERED
```

### Input Data
```java
events = List.of(
    new OrderStatusEvent("O1", PLACED, 0),
    new OrderStatusEvent("O1", PACKED, 10),
    new OrderStatusEvent("O1", SHIPPED, 100),
    new OrderStatusEvent("O2", PLACED, 0),
    new OrderStatusEvent("O2", PACKED, 60)
);
```

### Expected Output
```java
["O1", "O2"]
```

---

## Interview Notes
- Heavy use of `groupingBy`, `flatMap`, `filter`, `collectingAndThen`
- Time-window logic is critical
- Avoid mutable shared state
- Think about performance and edge cases

---

