# Diversified Hard Data Processing Problems (With Stories)

This document contains **diversified, real‑world, interview‑grade problems**.  
Each problem includes:
- A **story / business context**
- A **clear problem statement**
- **Concrete input data**
- **Expected output**

These are intentionally **not the same pattern**. Each problem tests a **different way of thinking** (time, state, sequence, math, sets, trends, etc.).

---

## 1. Fraud Detection Using Sliding Time Window

### Story
A bank wants to detect suspicious user behavior. Fraud often happens when multiple high‑value transactions occur in a short time.

### Problem
Flag users if **any 3 transactions** happen within **10 minutes** and their **total amount exceeds ₹100,000**.

### Input
```
U1: (10:00, 40k), (10:05, 35k), (10:08, 30k), (11:00, 50k)
U2: (10:00, 40k), (11:00, 70k)
```

### Output
```
[U1]
```

---

## 2. Order Status Validation (State Machine)

### Story
An e‑commerce system enforces strict order processing stages.

### Problem
An order must follow:
```
PLACED → PACKED → SHIPPED → DELIVERED
```
Detect orders that violate this sequence.

### Input
```
O1: PLACED → SHIPPED → PACKED
O2: PLACED → PACKED → SHIPPED
```

### Output
```
[O1]
```

---

## 3. Employee Burnout Detection

### Story
HR wants to identify employees who may be overworked.

### Problem
An employee is overworked if **on the same day**:
- Worked **more than 12 hours**
- Worked on **more than one project**

### Input
```
E1: (10 Jan, P1, 6h), (10 Jan, P2, 7h)
E2: (10 Jan, P1, 13h)
```

### Output
```
[E1]
```

---

## 4. First‑Time Customer Identification

### Story
Marketing wants to reward customers on the day they place their **first ever order**.

### Problem
For each day, find users who ordered **for the first time in their lifetime**.

### Input
```
Day1: U1, U2
Day2: U2, U3
```

### Output
```
Day1 → [U1, U2]
Day2 → [U3]
```

---

## 5. Revenue Growth Trend Detection

### Story
A product team wants to identify products that show consistent growth.

### Problem
Find products whose revenue **strictly increases every month**.

### Input
```
P1: Jan=100, Feb=150, Mar=200
P2: Jan=100, Feb=90,  Mar=120
```

### Output
```
[P1]
```

---

## 6. User Sessionization

### Story
An analytics team wants to group user activity into sessions.

### Problem
Create a new session if inactivity exceeds **30 minutes**.

### Input
```
U1: 10:00, 10:10, 11:00, 11:05
```

### Output
```
U1 → [[10:00,10:10], [11:00,11:05]]
```

---

## 7. Inventory Shortage Calculation

### Story
Operations needs to know which products cannot meet demand.

### Problem
Find products where **stock < demand** and calculate the **shortage amount**.

### Input
```
P1: stock=70, demand=100
P2: stock=200, demand=150
```

### Output
```
P1 → shortage 30
```

---

## 8. Top‑K Products per Category

### Story
Sales wants to promote the best‑selling products.

### Problem
Find **top 2 products per category** by sales.

### Input
```
Electronics: Phone=50, Laptop=40, TV=30
```

### Output
```
Electronics → [Phone, Laptop]
```

---

## 9. Cart vs Purchase Drop‑Off

### Story
Product managers want to identify abandoned carts.

### Problem
Find users who added products to cart but **never purchased**.

### Input
```
Cart:   (U1,P1), (U2,P2)
Orders: (U2,P2)
```

### Output
```
[U1]
```

---

## 10. Server Load Imbalance Detection

### Story
Infra team monitors uneven server traffic.

### Problem
Find servers handling **more than 150% of average load**.

### Input
```
S1=100, S2=200, S3=50
```

### Output
```
[S2]
```

---

## 11. Rolling Average Computation

### Story
Finance wants moving averages for trend analysis.

### Problem
Compute **3‑day rolling average**.

### Input
```
[10, 20, 30, 40]
```

### Output
```
[20, 30]
```

---

## 12. Outlier Detection

### Story
Monitoring detects abnormal spikes.

### Problem
Detect values that are **more than 2× the average**.

### Input
```
[10, 12, 11, 50]
```

### Output
```
[50]
```

---

## 13. Dependency Resolution

### Story
A build system must respect task dependencies.

### Problem
Find a valid execution order.

### Input
```
A → B, B → C
```

### Output
```
[A, B, C]
```

---

## 14. Latest Record Deduplication

### Story
Only the most recent record per user should be stored.

### Problem
Keep the **latest record per ID**.

### Input
```
U1@10:00, U1@11:00
```

### Output
```
U1@11:00
```

---

## 15. Funnel Drop‑Off Analysis

### Story
Growth team wants to know where users abandon the funnel.

### Problem
Find the stage with **maximum user drop**.

### Input
```
View=100, Cart=60, Pay=20
```

### Output
```
Cart → Pay
```

---

## 16. Meeting Conflict Detection

### Story
Calendar system must prevent overlapping meetings.

### Problem
Detect if any meetings overlap.

### Input
```
(10:00–11:00), (10:30–11:30)
```

### Output
```
Conflict
```

---

## 17. Fair Task Allocation

### Story
A manager wants to distribute tasks fairly.

### Problem
Distribute tasks evenly among workers.

### Input
```
Tasks=10, Workers=3
```

### Output
```
[4,3,3]
```

---

## 18. Metric Drift Detection

### Story
Analytics team watches for sudden behavior changes.

### Problem
Detect significant metric shift across periods.

### Input
```
Week1 avg=10
Week2 avg=25
```

### Output
```
Drift detected
```

---

## 19. Multi‑Condition Alerting

### Story
SRE team raises alerts only when multiple conditions fail.

### Problem
Alert if **error rate >5% AND latency >500ms**.

### Input
```
ServiceA: err=6%, lat=600ms
ServiceB: err=3%, lat=800ms
```

### Output
```
[ServiceA]
```

---

## 20. Capacity Breach Detection

### Story
Logistics wants to know when capacity is exceeded.

### Problem
Find the earliest day when cumulative usage exceeds capacity.

### Input
```
Day1=30, Day2=40, Day3=50 (capacity=100)
```

### Output
```
Day3
```

---

## Final Note
These problems intentionally force **different mental models**:
- Sliding windows
- Temporal state
- Sequence validation
- Statistical reasoning
- Set operations
- Graph dependencies
- Interval logic
- Mathematical derivation

👉 **Think first. Code second. Streams last.**

