# 30 Object-Oriented Real-World Interview Problems (Medium → Hard)

Each problem includes:
- Real-world **scenario**
- **OOP focus** (what classes / behaviors are relevant)
- Clear **task**
- Example **input dataset**
- Example **expected output**

---

## 1. Library Book Lending System (Medium)

**Scenario:**  
You are designing a small library system. The library has *Members* and *Books*. A member can borrow multiple books, a book can be borrowed by only one member at a time.

**OOP Focus:**
- Classes: `Book`, `Member`, `Loan` or `BorrowRecord`, `LibraryService`
- Behavior: `borrowBook`, `returnBook`, track issued books per member

**Task:**  
Given borrowing and returning events, find which books are currently issued to which member and which operations failed.

**Input (events):**

BOOKS:
- 1, "Clean Code"
- 2, "Effective Java"
- 3, "Design Patterns"

MEMBERS:
- 101, "Alice"
- 102, "Bob"

EVENTS (time-ordered):
- BORROW, 101, 1
- BORROW, 102, 2
- BORROW, 101, 2      (should fail: already borrowed by Bob)
- RETURN, 101, 1
- BORROW, 101, 3
- BORROW, 101, 2      (should fail: still with Bob)

**Expected Output (conceptual):**

Current Issued Books:  
- Member 101 (Alice): [Book 3 - "Design Patterns"]  
- Member 102 (Bob):   [Book 2 - "Effective Java"]  

Failed Operations:  
- BORROW, 101, 2 -> Book already issued (twice)

---

## 2. Parking Lot Management (Medium)

**Scenario:**  
You manage a multi-level parking lot with different vehicle types: `CAR`, `BIKE`, `TRUCK`. Each has different space requirements.

**OOP Focus:**
- Classes: `Vehicle` (abstract), `Car`, `Bike`, `Truck`, `ParkingSpot`, `Level`, `ParkingLot`, `Ticket`
- Behavior: `parkVehicle`, `leaveVehicle`, `getAvailableSpots`

**Task:**  
Simulate parking and leaving operations and output the final occupancy.

**Input:**

LEVELS: 2  
LEVEL 1: 4 spots  
LEVEL 2: 3 spots  

EVENTS:
- ENTER, CAR, KA-01-AA-1111
- ENTER, BIKE, KA-02-BB-2222
- ENTER, CAR, KA-03-CC-3333
- LEAVE, KA-01-AA-1111
- ENTER, TRUCK, KA-04-DD-4444  (occupies 2 spots)
- ENTER, CAR, KA-05-EE-5555

**Expected Output (example layout):**

Occupied Spots:  
- KA-02-BB-2222 -> Level 1, Spot 2  
- KA-03-CC-3333 -> Level 1, Spot 3  
- KA-04-DD-4444 -> Level 1, Spot 4 & Level 2, Spot 1  
- KA-05-EE-5555 -> Level 2, Spot 2  

Available Spots:  
- Level 2, Spot 3

---

## 3. Food Delivery Order Tracking (Medium)

**Scenario:**  
You model a Swiggy/Zomato-type system with a fixed status flow:  
`RECEIVED → ACCEPTED → PREPARING → PICKED_UP → DELIVERED`

**OOP Focus:**
- Classes: `Order`, `OrderStatus`, `Restaurant`, `DeliveryAgent`, `OrderService`
- Behavior: `updateStatus(orderId, newStatus)` with validation (no skipping or going backwards)

**Task:**  
From a list of status updates, show:
1. Orders successfully delivered
2. Orders in progress and at which stage
3. Orders with invalid transitions

**Input:**

ORDERS:
- O1, Restaurant R1
- O2, Restaurant R1
- O3, Restaurant R2

STATUS UPDATES (time-ordered):
- O1, RECEIVED
- O1, ACCEPTED
- O1, PREPARING
- O1, PICKED_UP
- O1, DELIVERED

- O2, RECEIVED
- O2, ACCEPTED
- O2, PREPARING

- O3, RECEIVED
- O3, ACCEPTED
- O3, PICKED_UP     (invalid: skipped PREPARING)

**Expected Output (conceptual):**

Delivered Orders:  
- O1

In-Progress Orders:  
- O2 -> PREPARING

Invalid Orders:  
- O3 -> Invalid transition ACCEPTED → PICKED_UP

---

## 4. Online Course Progress Tracker (Medium)

**Scenario:**  
Students must finish modules in order: `INTRO → BASICS → ADVANCED → PROJECT → EXAM`.

**OOP Focus:**
- Classes: `Student`, `Course`, `Module`, `ModuleCompletion`, `CourseProgressService`
- Behavior: validating module order and computing total completion time

**Task:**  
Given module completion events, find:
- Students who completed the course
- Their total time to completion
- The fastest student

**Input:**

MODULES: INTRO, BASICS, ADVANCED, PROJECT, EXAM

EVENTS:
- Alice, INTRO, 5
- Alice, BASICS, 10
- Alice, ADVANCED, 20
- Alice, PROJECT, 15
- Alice, EXAM, 10

- Bob, INTRO, 4
- Bob, BASICS, 8
- Bob, PROJECT, 15     (skipped ADVANCED -> invalid)
- Bob, ADVANCED, 20    (out of order)

- Charlie, INTRO, 6
- Charlie, BASICS, 9
- Charlie, ADVANCED, 18
- Charlie, PROJECT, 17
- Charlie, EXAM, 11

**Expected Output:**

Valid Completions:  
- Alice  -> Total Time = 60  
- Charlie-> Total Time = 61  

Fastest Student:  
- Alice (60)

Invalid Progress:  
- Bob -> Wrong module order

---

## 5. Movie Ticket Booking System (Medium)

**Scenario:**  
A cinema hall has shows, seats, and bookings. Multiple users can attempt to book the same seat.

**OOP Focus:**
- Classes: `Show`, `Seat`, `User`, `Booking`, `BookingService`
- Behavior: seat availability checking, booking creation

**Task:**  
Process booking requests and output:
- Successful bookings
- Rejected bookings with reason

**Input:**

SHOW: S1 (Movie: "Inception", Time: 7 PM)  
SEATS: A1, A2, A3  

BOOKING REQUESTS:
- U1, S1, A1
- U2, S1, A2
- U3, S1, A1   (should fail, already booked)
- U4, S1, A3
- U5, S1, A2   (should fail)

**Expected Output:**

Successful Bookings:  
- U1 -> S1, A1  
- U2 -> S1, A2  
- U4 -> S1, A3  

Failed Bookings:  
- U3 -> Seat A1 already booked  
- U5 -> Seat A2 already booked  

---

## 6. E-Commerce Shopping Cart & Discounts (Medium)

**Scenario:**  
Each user has a cart with items, quantities, and category-based discounts.

**OOP Focus:**
- Classes: `Product`, `Category`, `CartItem`, `Cart`, `User`, `DiscountPolicy`, `PricingService`
- Behavior: computing total, applying category + cart-level discounts

**Task:**  
Apply discount rules and calculate payable amounts.

**Rules:**
- Electronics: 10% off
- Grocery: 5% off
- If total > 5000, extra 5% off on entire cart

**Input:**

PRODUCTS:
- P1, "Laptop", ELECTRONICS, 40000
- P2, "Mouse", ELECTRONICS, 500
- P3, "Rice Bag", GROCERY, 1000

CART (for User U1):
- P1 x 1
- P2 x 2
- P3 x 3

**Expected Output (stepwise):**

Cart Total Before Discounts:  
40000 + (500 × 2) + (1000 × 3) = 44000  

Category Discounts:  
- Electronics (P1 + P2): 10% of (40000 + 1000) = 4100  
- Grocery (P3): 5% of 3000 = 150  

After Category Discounts: 44000 − 4100 − 150 = 39750  

Additional 5% discount (total > 5000):  
5% of 39750 = 1987.5 ≈ 1988  

Final Payable: 39750 − 1988 = **37762**

---

## 7. Employee Attendance & Late Coming (Medium)

**Scenario:**  
Track employee office entry times. If they come after 10:00 AM, it's a "late entry".

**OOP Focus:**
- Classes: `Employee`, `AttendanceRecord`, `AttendanceService`
- Behavior: time parsing, comparison, late-count logic

**Task:**  
Compute for each employee:
- Total days present
- Number of late entries

**Input:**

LATE_TIME = 10:00

RECORDS:
- Emp1, 2025-11-20, 09:55
- Emp1, 2025-11-21, 10:05
- Emp2, 2025-11-20, 10:30
- Emp2, 2025-11-21, 09:45
- Emp3, 2025-11-20, 11:00

**Expected Output:**

- Emp1: Present = 2, Late = 1  
- Emp2: Present = 2, Late = 1  
- Emp3: Present = 1, Late = 1  

---

## 8. Bank Account Transaction Processor (Medium–Hard)

**Scenario:**  
You model bank accounts and transactions (DEPOSIT, WITHDRAW). Account balance cannot go below zero.

**OOP Focus:**
- Classes: `Account`, `Transaction`, `TransactionType`, `BankService`
- Behavior: `applyTransaction`, `getBalance`, handle failures

**Task:**  
Given transactions, compute final balance per account and failed transactions.

**Input:**

ACCOUNTS:
- A1, Initial = 1000
- A2, Initial = 500

TRANSACTIONS:
- A1, DEPOSIT, 500
- A1, WITHDRAW, 200
- A2, WITHDRAW, 600   (fail: insufficient balance)
- A2, DEPOSIT, 1000
- A2, WITHDRAW, 1200

**Expected Output:**

Final Balances:  
- A1 -> 1300  
- A2 -> 300  

Failed Transactions:  
- A2, WITHDRAW, 600 -> Insufficient funds  

---

## 9. Ride-Sharing Simple Matching (Medium–Hard)

**Scenario:**  
Simple Uber/Ola style: match riders to drivers in the same area (zone).

**OOP Focus:**
- Classes: `Rider`, `Driver`, `Location` or `Zone`, `RideRequest`, `RideService`
- Behavior: matching algorithm, driver availability

**Task:**  
Given drivers & ride requests, assign each request to an available driver in the same zone (first-come-first-serve).

**Input:**

DRIVERS:
- D1, Zone A
- D2, Zone B
- D3, Zone A

RIDE REQUESTS (in order):
- R1, Zone A
- R2, Zone B
- R3, Zone A
- R4, Zone A   (no driver left -> unassigned)

**Expected Output:**

Assignments:  
- R1 -> D1  
- R2 -> D2  
- R3 -> D3  
- R4 -> No driver available  

---

## 10. Warehouse Inventory System (Medium–Hard)

**Scenario:**  
Warehouse tracks stock for products via `IN` (add stock) and `OUT` (remove stock) operations.

**OOP Focus:**
- Classes: `Product`, `InventoryMovement`, `MovementType`, `InventoryService`
- Behavior: stock management, negative stock protection

**Task:**  
From movement logs, compute final stock and highlight invalid operations.

**Input:**

PRODUCTS:
- P1, "iPhone"
- P2, "TV"

MOVEMENTS:
- IN, P1, 10
- OUT, P1, 3
- OUT, P1, 8   (invalid: only 7 left)
- IN, P2, 5
- OUT, P2, 2
- OUT, P2, 3
- OUT, P2, 1   (invalid: only 0 left)

**Expected Output:**

Final Stock:  
- P1 -> 7  
- P2 -> 0  

Invalid Movements:  
- OUT, P1, 8  
- OUT, P2, 1  

---

## 11. Flight Reservation with Overbooking Rule (Medium–Hard)

**Scenario:**  
Airline allows up to 10% overbooking (seats + 10% rounded down). Beyond that, reject bookings.

**OOP Focus:**
- Classes: `Flight`, `Passenger`, `Booking`, `BookingService`
- Behavior: enforcing capacity and overbooking rules

**Task:**  
For a given flight, process bookings and mark accepted/rejected.

**Input:**

FLIGHT F1: Capacity = 10  
Allowed Booking = 10 + floor(10% of 10) = 11  

BOOKING REQUESTS (names):  
P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12

**Expected Output:**

Accepted:  
- P1 to P11  

Rejected:  
- P12 -> Overbooking limit reached  

---

## 12. Online Poll / Voting System (Medium–Hard)

**Scenario:**  
Each user can vote for one option in a poll. Multiple votes by same user -> only the first counts.

**OOP Focus:**
- Classes: `Poll`, `Option`, `User`, `Vote`, `PollService`
- Behavior: idempotent voting per user

**Task:**  
Count final votes per option.

**Input:**

OPTIONS: A, B, C

VOTES (time-ordered):
- U1, A
- U2, B
- U1, C  (ignored)
- U3, B
- U4, A
- U2, C  (ignored)
- U5, B

**Expected Output:**

Vote Count:  
- A -> 2 (U1, U4)  
- B -> 3 (U2, U3, U5)  
- C -> 0  

---

## 13. Task Scheduling with Dependencies (Hard)

**Scenario:**  
You have tasks with dependencies (like a build system). A task can run only after its dependencies finish.

**OOP Focus:**
- Classes: `Task`, `DependencyGraph`, `Scheduler`
- Behavior: topological sorting, cycle detection

**Task:**  
Given tasks and dependencies, output a valid execution order or detect cycle.

**Input:**

TASKS: T1, T2, T3, T4

DEPENDENCIES:
- T2 depends on T1
- T3 depends on T2
- T4 depends on T2

**Expected Output (one valid order):**

- T1, T2, T3, T4  
or  
- T1, T2, T4, T3  

If one more dependency added: `T1 depends on T3`, then:

Output:  
- Cycle detected, no valid schedule

---

## 14. Rate Limiter per User (Hard)

**Scenario:**  
You are building a basic rate limiter: each user can make at most 3 API calls in any rolling 10-second window.

**OOP Focus:**
- Classes: `Request`, `User`, `RateLimiter`
- Behavior: window-based counting, timestamp handling

**Task:**  
For a sequence of requests (with timestamps), decide allow/deny.

**Input:**

WINDOW = 10 seconds  
LIMIT = 3 calls  

REQUESTS (time in seconds from start):
- UserA, t=1
- UserA, t=2
- UserA, t=3
- UserA, t=11
- UserA, t=12
- UserA, t=13

- UserB, t=5
- UserB, t=6
- UserB, t=14
- UserB, t=15

**Expected Output (conceptual):**

UserA @1  -> ALLOW (count=1)  
UserA @2  -> ALLOW (count=2)  
UserA @3  -> ALLOW (count=3)  
UserA @11 -> ALLOW (window 2..11 -> 3 calls: 2,3,11)  
UserA @12 -> DENY  (would be 4 in window 3..12)  
UserA @13 -> DENY  

UserB @5  -> ALLOW  
UserB @6  -> ALLOW  
UserB @14 -> ALLOW (window 5..14 -> 3 calls: 5,6,14)  
UserB @15 -> DENY  

---

## 15. Chat Room Message Ordering with Delays (Medium–Hard)

**Scenario:**  
Chat messages from users may arrive out of order due to network delays, but each has a server timestamp.

**OOP Focus:**
- Classes: `Message`, `User`, `ChatRoom`, `ChatService`
- Behavior: grouping by room, sorting by timestamp

**Task:**  
Given unsorted messages, group by chat room and sort by timestamp.

**Input:**

MESSAGES:
- Room1, UserA, "Hi", t=5
- Room1, UserB, "Hello", t=3
- Room2, UserC, "Welcome", t=4
- Room1, UserA, "How are you?", t=10
- Room2, UserD, "Thanks", t=6

**Expected Output:**

Room1:  
- [t=3 ] UserB: Hello  
- [t=5 ] UserA: Hi  
- [t=10] UserA: How are you?  

Room2:  
- [t=4 ] UserC: Welcome  
- [t=6 ] UserD: Thanks  

---

## 16. Log Analyzer – Most Frequent Error by Service (Medium–Hard)

**Scenario:**  
Each log line has: timestamp, serviceName, level (INFO/WARN/ERROR), message.

**OOP Focus:**
- Classes: `LogEntry`, `ServiceLogReport`, `LogAnalyzer`
- Behavior: grouping, counting, summarizing

**Task:**  
For each service, find how many ERROR logs it has and which service is most error-prone.

**Input:**

LOGS:
- t1, AuthService, INFO,  "Started"
- t2, OrderService, ERROR, "DB down"
- t3, AuthService, ERROR, "Invalid token"
- t4, OrderService, ERROR, "Timeout"
- t5, PaymentService, WARN, "Slow response"
- t6, AuthService, ERROR, "User not found"

**Expected Output:**

Error Counts:  
- AuthService    -> 3  
- OrderService   -> 2  
- PaymentService -> 0  

Most Error-Prone:  
- AuthService  

---

## 17. Hospital Appointment Scheduler (Medium–Hard)

**Scenario:**  
Doctors have appointment slots (start time, end time). Patients book appointments.

**OOP Focus:**
- Classes: `Doctor`, `Patient`, `Appointment`, `TimeSlot`, `Scheduler`
- Behavior: conflict detection for requested time slots

**Task:**  
For each booking request, accept or reject based on doctor’s availability.

**Input:**

Doctor D1 existing appointments:  
- [09:00–09:30], [10:00–10:30]

Requests:
- P1 wants 09:15–09:45 -> reject (overlaps with 09:00–09:30)
- P2 wants 09:30–10:00 -> accept
- P3 wants 10:15–10:45 -> reject (overlaps with 10:00–10:30)
- P4 wants 11:00–11:30 -> accept

**Expected Output:**

- P1 -> REJECT (overlap)  
- P2 -> ACCEPT  
- P3 -> REJECT (overlap)  
- P4 -> ACCEPT  

---

## 18. Subscription Billing with Proration (Hard)

**Scenario:**  
Users subscribe to monthly plans. If they upgrade mid-month, you need to prorate cost.

**OOP Focus:**
- Classes: `User`, `Plan`, `Subscription`, `BillingCycle`, `BillingService`
- Behavior: date math, pro-rated charge calculation

**Task:**  
Calculate charge for a user upgrading from Basic to Premium mid-cycle.

**Input:**

MONTH = 30 days  
PLAN Basic   = ₹300/month  
PLAN Premium = ₹900/month  

User subscribed to Basic on Day 1.  
On Day 11, upgrades to Premium.  

Assume:  
- Basic for first 10 days already paid.  
- Need additional upgrade charge from Day 11–30.

**Expected Output (one interpretation):**

Basic per day   = 300 / 30 = 10  
Premium per day = 900 / 30 = 30  
Difference/day  = 20  

Days remaining = 20 (11–30 inclusive)  
Extra charge   = 20 × 20 = **₹400**  

(Exact handling of boundaries is an intentional design discussion.)

---

## 19. Product Recommendation by Co-Purchase (Hard)

**Scenario:**  
Given orders, you want to recommend products frequently bought together.

**OOP Focus:**
- Classes: `Order`, `Product`, `RecommendationService`
- Behavior: building co-purchase matrix, querying recommendations

**Task:**  
For a given product, find top 2 most co-purchased products.

**Input:**

ORDERS:
- O1: [P1, P2, P3]
- O2: [P1, P2]
- O3: [P2, P3]
- O4: [P1, P3]
- O5: [P1, P2, P4]

Query: For product P1, find top 2 co-purchased.

**Expected Output:**

For P1, co-purchased counts:  
- P2: in O1, O2, O5 -> 3  
- P3: in O1, O4     -> 2  
- P4: in O5         -> 1  

Top 2:  
- P2, P3  

---

## 20. Multi-Level Comment Thread (Hard)

**Scenario:**  
Implement YouTube/Reddit-style comments: each comment can have replies (nested).

**OOP Focus:**
- Classes: `Comment`, `User`, `Post`, `CommentService`
- Behavior: storing parent-child relations, tree traversal

**Task:**  
Given a list of comments with parent-child relations, print them in a nested, indented format.

**Input:**

COMMENTS:
- C1: "First!"      by U1, parent = null
- C2: "Nice video"  by U2, parent = C1
- C3: "Thanks!"     by U1, parent = C2
- C4: "I disagree"  by U3, parent = C1
- C5: "Why?"        by U2, parent = C4

**Expected Output:**

C1 (U1): First!  
  C2 (U2): Nice video  
    C3 (U1): Thanks!  
  C4 (U3): I disagree  
    C5 (U2): Why?  

---

## 21. Online Marketplace Seller Rating System (Medium–Hard)

**Scenario:**  
You are designing a marketplace like Amazon. Buyers can rate sellers from 1 to 5 stars after an order is completed.

**OOP Focus:**
- Classes: `Seller`, `Buyer`, `Order`, `Rating`, `RatingService`
- Behavior: accepting ratings, computing average seller rating, preventing multiple ratings per order

**Task:**  
Given orders and ratings, compute the final average rating per seller and identify the top-rated seller (by average, then by number of ratings).

**Input:**

ORDERS:
- O1: Buyer B1, Seller S1
- O2: Buyer B2, Seller S1
- O3: Buyer B3, Seller S2
- O4: Buyer B4, Seller S2
- O5: Buyer B5, Seller S2

RATINGS:
- O1, 5
- O2, 4
- O3, 3
- O4, 5
- O5, 5
- O1, 1   (ignored: duplicate rating for same order)

**Expected Output:**

Seller Ratings:  
- S1 -> (5 + 4) / 2 = 4.5 (2 ratings)  
- S2 -> (3 + 5 + 5) / 3 = 4.33 (3 ratings)  

Top Seller (by avg, tie-breaker: rating count):  
- S1 (avg 4.5, 2 ratings)  

---

## 22. Subscription-Based Video Platform – Watch History (Medium–Hard)

**Scenario:**  
Design a watch history for a video streaming platform (like Netflix). Each user watches videos; later you want to show "Continue Watching" list sorted by most recent watch time.

**OOP Focus:**
- Classes: `User`, `Video`, `WatchEvent`, `WatchHistoryService`
- Behavior: recording watch events, computing latest timestamp per video per user

**Task:**  
Given a list of watch events, generate for each user a "continue watching" list: videos sorted by latest watch time.

**Input:**

WATCH EVENTS:
- U1, V1, t=10
- U1, V2, t=12
- U1, V1, t=15
- U2, V3, t=11
- U2, V4, t=9
- U2, V3, t=20

**Expected Output:**

User U1:  
- V1 (last watched at t=15)  
- V2 (t=12)  

User U2:  
- V3 (t=20)  
- V4 (t=9)  

---

## 23. Expense Splitter for Group Trips (Medium–Hard)

**Scenario:**  
You are designing something like Splitwise. Friends share expenses in a group trip, and you want to compute who owes how much to whom to settle up.

**OOP Focus:**
- Classes: `User`, `Expense`, `Group`, `SettlementService`
- Behavior: storing expenses, computing net balances, suggesting minimal transactions

**Task:**  
Given expenses with payer and shared users, compute net balance per user (positive = others owe them, negative = they owe others).

**Input:**

USERS: A, B, C

EXPENSES:
- A paid 300 for dinner (split among A, B, C)
- B paid 150 for taxi (split among B, C)
- C paid 90 for snacks (split among A, C)

**Expected Output (one possible breakdown):**

Total per person:  
- Dinner 300 split 3 ways -> 100 each  
- Taxi 150 split 2 ways  -> 75 each (B, C)  
- Snacks 90 split 2 ways -> 45 each (A, C)  

Actual Paid:  
- A: 300  
- B: 150  
- C: 90  

Fair Share:  
- A: 100 (dinner) + 45 (snacks) = 145  
- B: 100 (dinner) + 75 (taxi)   = 175  
- C: 100 (dinner) + 75 (taxi) + 45 (snacks) = 220  

Net Balance (Paid − Fair Share):  
- A: 300 − 145 = +155  
- B: 150 − 175 = −25  
- C: 90 − 220  = −130  

Interpretation (simplified):  
- B pays 25 to A  
- C pays 130 to A  

---

## 24. Job Application Tracking System (Medium–Hard)

**Scenario:**  
You are designing a job portal’s applicant tracking system (ATS). Applications go through stages: `APPLIED → SCREENING → INTERVIEW → OFFERED → HIRED` or `REJECTED` at any point.

**OOP Focus:**
- Classes: `Candidate`, `Job`, `Application`, `Stage`, `ApplicationService`
- Behavior: stage transitions, rejection logic, reporting

**Task:**  
Given stage update events for applications, compute:
- Number of candidates at each stage
- List of candidates who were offered but not hired

**Input:**

APPLICATIONS:
- A1: Candidate C1, Job J1
- A2: Candidate C2, Job J1
- A3: Candidate C3, Job J2

STAGE UPDATES:
- A1: APPLIED → SCREENING → INTERVIEW → OFFERED → HIRED
- A2: APPLIED → SCREENING → REJECTED
- A3: APPLIED → SCREENING → INTERVIEW → OFFERED

**Expected Output:**

Current Stage Counts:  
- APPLIED: 0  
- SCREENING: 0  
- INTERVIEW: 0  
- OFFERED: 1 (A3)  
- HIRED: 1 (A1)  
- REJECTED: 1 (A2)  

Offered but not hired:  
- A3 (Candidate C3, Job J2)  

---

## 25. Logistics – Delivery Route Cost Calculator (Medium–Hard)

**Scenario:**  
A logistics company ships packages between cities. Each route has a cost, and you want to compute total shipping cost per package based on the sequence of legs.

**OOP Focus:**
- Classes: `City`, `Route`, `Package`, `ShipmentLeg`, `ShipmentService`
- Behavior: validating legs form a valid path, computing total cost

**Task:**  
Given defined route costs and package shipment legs, compute final shipping cost for each package.

**Input:**

ROUTES (directed with cost):  
- A → B : 100  
- B → C : 200  
- A → C : 500  

PACKAGES:
- P1: A → B → C  
- P2: A → C  
- P3: A → B → D (invalid: route B→D missing)

**Expected Output:**

- P1: cost = 100 + 200 = 300  
- P2: cost = 500  
- P3: INVALID ROUTE (no B→D)  

---

## 26. Coupon System with Usage Limits (Medium–Hard)

**Scenario:**  
Your e-commerce system has discount coupons. Each coupon can have: max total usage, max usage per user, expiry date, and minimum order value.

**OOP Focus:**
- Classes: `Coupon`, `User`, `Order`, `CouponRedemption`, `CouponService`
- Behavior: validating redemption rules

**Task:**  
Given coupon definitions and redemption attempts, decide for each attempt whether it is accepted or rejected with reason.

**Input:**

COUPON C1:  
- Discount: flat ₹100  
- Max Total Usage: 3  
- Max Per User: 2  
- Min Order Value: 500  

ATTEMPTS:
- U1, OrderAmount=600 -> ACCEPT (1st use, total=1)  
- U1, OrderAmount=400 -> REJECT (order too small)  
- U1, OrderAmount=700 -> ACCEPT (2nd use, total=2)  
- U2, OrderAmount=800 -> ACCEPT (1st use, total=3)  
- U3, OrderAmount=900 -> REJECT (total usage exceeded)  

**Expected Output:**

- Attempt 1: ACCEPT  
- Attempt 2: REJECT (min order not met)  
- Attempt 3: ACCEPT  
- Attempt 4: ACCEPT  
- Attempt 5: REJECT (coupon usage limit reached)  

---

## 27. Inventory Reservation for Flash Sale (Hard)

**Scenario:**  
During a flash sale, many users try to buy the same product. You must reserve inventory during payment, and confirm or cancel based on payment result.

**OOP Focus:**
- Classes: `Product`, `Inventory`, `Reservation`, `Order`, `Payment`, `FlashSaleService`
- Behavior: reservation, timeout/expiry handling, overbooking prevention

**Task:**  
Given inventory, reservation attempts, and payment results, compute final sold quantity and remaining available stock.

**Input:**

PRODUCT P1: Stock = 5

EVENTS (time-ordered):  
- RESERVE, U1, qty=2  -> success (reserved 2)  
- RESERVE, U2, qty=3  -> success (reserved 3)  
- RESERVE, U3, qty=1  -> fail (no stock left)  

Payments:  
- PAYMENT_SUCCESS, U1  
- PAYMENT_FAIL, U2  

**Expected Output:**

Final Sold:  
- U1 bought 2  

Stock Released from Failed Reservations:  
- U2’s 3 reserved items returned  

Final Available Stock for P1:  
- 5 − 2 = 3  

---

## 28. Notification Scheduling System (Hard)

**Scenario:**  
You build a notification system that schedules messages (email/push/SMS) to be sent at certain times, with retry on failure (max 3 attempts).

**OOP Focus:**
- Classes: `Notification`, `NotificationType`, `User`, `NotificationSchedule`, `NotificationService`
- Behavior: scheduling, retry policy, status tracking

**Task:**  
Given scheduled notifications with simulated send results per attempt, compute final status of each notification (`SENT`, `FAILED`, `PENDING`).

**Input:**

NOTIFICATIONS:
- N1: User U1, sendAt=10:00
- N2: User U2, sendAt=10:05

SEND RESULTS (per attempt, in order):  
- N1: FAIL, FAIL, SUCCESS  
- N2: FAIL, FAIL, FAIL  

**Expected Output:**

- N1 -> SENT (after 3rd attempt)  
- N2 -> FAILED (after 3 failed attempts)  

---

## 29. Social Network – Friend Suggestion (Hard)

**Scenario:**  
You are designing a basic friend suggestion feature: "People You May Know". Suggest friends-of-friends who are not already direct friends.

**OOP Focus:**
- Classes: `User`, `Friendship`, `SocialGraph`, `SuggestionService`
- Behavior: graph traversal, exclusion of existing direct friends & self

**Task:**  
For a given user, compute friend suggestions sorted by number of mutual friends (descending).

**Input:**

USERS: A, B, C, D, E

FRIENDSHIPS (undirected):  
- A - B  
- B - C  
- C - D  
- A - E  

Query: suggestions for A.

**Expected Output:**

- Direct friends of A: B, E  
- Friends-of-friends:  
  - via B: C  
  - via E: (none)  
  - via C: D (through B → C → D, but C already considered)  

Mutual friend counts for A:  
- C -> 1 mutual friend (B)  
- D -> 0 mutuals (also more than 2 hops; may or may not include depending on design)  

If we restrict to distance 2 only:  
- Suggestions: [C]  

---

## 30. Multi-Tenant SaaS Billing (Hard)

**Scenario:**  
You build a SaaS app used by multiple companies (tenants). Each tenant has users and a subscription plan that defines price per active user per month. Some tenants have discounts.

**OOP Focus:**
- Classes: `Tenant`, `User`, `Plan`, `Subscription`, `BillingService`
- Behavior: counting active users per tenant, applying plan pricing & tenant-level discounts

**Task:**  
Given tenants, users (with active flags), and plan pricing, compute monthly bill per tenant.

**Input:**

PLANS:  
- BASIC: ₹100 per active user/month  
- PRO:   ₹250 per active user/month  

TENANTS:  
- T1: Plan=BASIC, Discount=0%  
- T2: Plan=PRO,   Discount=10%  

USERS:  
- U1: Tenant T1, active=true  
- U2: Tenant T1, active=false  
- U3: Tenant T1, active=true  
- U4: Tenant T2, active=true  
- U5: Tenant T2, active=true  
- U6: Tenant T2, active=true  

**Expected Output:**

Active user counts:  
- T1: 2 users (U1, U3)  
- T2: 3 users (U4, U5, U6)  

Raw Bill:  
- T1: 2 × 100 = 200  
- T2: 3 × 250 = 750  

After Discount:  
- T1: 200 (no discount)  
- T2: 750 − 10% of 750 = 750 − 75 = **675**  

Final Monthly Bills:  
- T1 -> ₹200  
- T2 -> ₹675  

---

This set of 30 problems is designed to strengthen:

- Object modeling & relationships  
- Business rule implementation  
- Use of collections & (optionally) Java streams  
- Reasoning about edge cases and constraints  

You can turn each into:
- A full Java design exercise (classes + methods)
- Implementation task (services and unit tests)
- Or mock interview questions.
