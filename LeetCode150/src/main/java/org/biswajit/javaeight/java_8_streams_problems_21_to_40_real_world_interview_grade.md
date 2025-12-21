# Java 8 Streams – Problems 21 to 40 (Real-World, Interview Grade)

These problems are designed to test **real-world stream usage**, not syntax memorization.
Each problem includes **context, rules, input, and expected output**, similar to senior product-company interviews.

---

## 21. Order Status Funnel Analysis

### Business Context
In a real e-commerce system, an order does not move in a single step. It passes through multiple **status transitions** such as creation, payment, shipping, and final delivery. Product managers and operations teams often want to analyze how many orders actually reach each stage of this funnel to identify drop-offs.

### Problem Statement
You are given a list of **order status update events**. Each event represents that a particular order reached a specific status at some point in time.

Your task is to calculate how many **unique orders** reached each status at least once.

### Rules
- Each order must be counted **only once per status**, even if the same status appears multiple times for that order.
- Some orders may not reach all statuses.
- The expected output should contain all known statuses, even if the count is zero.

### Input
```
O1 CREATED
O1 PAID
O1 SHIPPED
O2 CREATED
O2 PAID
O3 CREATED
```

### Output
```
CREATED -> 3
PAID -> 2
SHIPPED -> 1
DELIVERED -> 0
```

---

## 22. Average Cart Value per User (Ignore Abandoned Carts)

### Business Context
In shopping platforms, users often create carts but do not complete the checkout. These abandoned carts should not be considered when calculating user spending behavior.

### Problem Statement
You are given cart records that belong to users. Each cart has a total value and a final status indicating whether it was checked out or abandoned.

Your task is to compute the **average cart value per user**, considering **only those carts that were successfully checked out**.

### Rules
- Ignore carts with status `ABANDONED`.
- Each checked-out cart contributes one value to the average.
- Users with no checked-out carts should not appear in the result.

### Input
```
U1 500 CHECKED_OUT
U1 300 ABANDONED
U2 400 CHECKED_OUT
```

### Output
```
U1 -> 500
U2 -> 400
```

---

## 23. Users with Increasing Purchase Trend

### Problem Statement
A user has an increasing purchase trend if their order amounts are **strictly increasing over time**.

### Input
```
U1 2024-01 200
U1 2024-02 300
U1 2024-03 500
U2 2024-01 400
U2 2024-02 300
```

### Output
```
[U1]
```

---

## 24. Products Sold in All Regions

### Problem Statement
Each sale record contains `(productId, region)`.

Find products that were sold in **every region** from the given region list.

### Input
```
Regions: [NORTH, SOUTH, EAST]

P1 NORTH
P1 SOUTH
P1 EAST
P2 NORTH
P2 SOUTH
```

### Output
```
[P1]
```

---

## 25. Total Session Duration per User

### Problem Statement
Each session has `(userId, sessionStart, sessionEnd)`.

Calculate the **total session duration per user (in minutes)**.

### Input
```
U1 10:00 10:30
U1 11:00 11:20
U2 10:00 10:10
```

### Output
```
U1 -> 50
U2 -> 10
```

---

## 26. Most Frequently Purchased Product per Category

### Problem Statement
Each order item has `(productId, category)`.

Find the **most frequently purchased product** in each category.

### Input
```
Electronics: Phone, Phone, TV
Grocery: Rice, Rice, Wheat
```

### Output
```
Electronics -> Phone
Grocery -> Rice
```

---

## 27. Orders with Partial Fulfillment

### Problem Statement
An order is partially fulfilled if:
- At least one item is `DELIVERED`
- At least one item is `CANCELLED`

### Input
```
O1 DELIVERED
O1 CANCELLED
O2 DELIVERED
```

### Output
```
[O1]
```

---

## 28. Top-K Customers by Lifetime Spend

### Problem Statement
Given `(customerId, amount)` records, find the **top K customers** by total spend.

### Input
```
C1 500
C1 300
C2 700
C3 200
```

### Output (K = 2)
```
[C2, C1]
```

---

## 29. Longest Continuous Login Streak

### Problem Statement
Each user has a list of login dates.

Find the **longest continuous daily login streak per user**.

### Input
```
U1: Jan1, Jan2, Jan3, Jan5
U2: Jan1, Jan2
```

### Output
```
U1 -> 3
U2 -> 2
```

---

## 30. Normalize and Group Emails by Domain

### Problem Statement
Normalize email IDs (trim spaces, lowercase) and group users by **email domain**.

### Input
```
" John@Gmail.com "
" alice@yahoo.com"
```

### Output
```
gmail.com -> [john]
yahoo.com -> [alice]
```

---

## 31. Detect Price Drop Alerts

### Problem Statement
Trigger an alert if a product price drops **more than 20% compared to the previous price**.

### Input
```
P1 100
P1 70
P2 200
P2 190
```

### Output
```
[P1]
```

---

## 32. Group Orders by Delivery SLA Breach

### Problem Statement
Group orders as:
- `ON_TIME` (delivered on or before promised date)
- `DELAYED` (delivered after promised date)

### Input
```
O1 Jan10 Jan10
O2 Jan10 Jan12
O3 Jan10 Jan9
```

### Output
```
ON_TIME -> [O1, O3]
DELAYED -> [O2]
```

---

## 33. User Engagement Scoring

### Problem Statement
Each activity contributes to engagement:
- LOGIN = 1
- CLICK = 2
- PURCHASE = 5

Calculate total engagement score per user.

### Input
```
U1 LOGIN
U1 CLICK
U1 PURCHASE
U2 LOGIN
```

### Output
```
U1 -> 8
U2 -> 1
```

---

## 34. Products with Zero Sales

### Problem Statement
Given:
- All catalog products
- Products that were sold

Find products that were **never sold**.

### Input
```
All: [P1, P2, P3]
Sold: [P1, P3]
```

### Output
```
[P2]
```

---

## 35. Rolling 3-Day Average Sales

### Problem Statement
Given daily sales in chronological order, compute the **rolling 3-day average**.

### Input
```
Day1 100
Day2 200
Day3 300
Day4 400
```

### Output
```
Day3 -> 200
Day4 -> 300
```

---

## 36. Deduplicate Users by Latest Update

### Problem Statement
User profiles may arrive multiple times.

Keep only the **latest update per user**.

### Input
```
U1 10:00
U1 12:00
U2 11:00
```

### Output
```
U1 -> 12:00
U2 -> 11:00
```

---

## 37. Orders with All Items Returned

### Problem Statement
An order is fully returned if **all its items** have status `RETURNED`.

### Input
```
O1 RETURNED
O1 RETURNED
O2 RETURNED
O2 DELIVERED
```

### Output
```
[O1]
```

---

## 38. Categorize Users by Spending Bracket

### Problem Statement
Classify users based on lifetime spend:
- LOW < 1000
- MEDIUM 1000–10000
- HIGH > 10000

### Input
```
U1 500
U2 3000
U3 15000
```

### Output
```
LOW -> [U1]
MEDIUM -> [U2]
HIGH -> [U3]
```

---

## 39. Build Inverted Index for Search

### Problem Statement
Given `(productId, description)`, build an inverted index:

`word -> list of productIds`

Rules:
- Ignore case
- Ignore punctuation

### Input
```
P1 "Red Apple Fresh"
P2 "Fresh Green Apple"
```

### Output
```
apple -> [P1, P2]
fresh -> [P1, P2]
red -> [P1]
green -> [P2]
```

---

## 40. Detect Suspicious High-Frequency Actions

### Problem Statement
A user is suspicious if they perform **more than N actions within any 1-hour window**.

### Input (N = 3)
```
U1 10:00
U1 10:10
U1 10:20
U1 10:30
U2 11:00
U2 12:30
```

### Output
```
[U1]
```

---

### End of Problems 21–40

These problems test:
- groupingBy + downstream collectors
- flatMap
- reduce
- sorting and windowing
- real business reasoning

