# Java Streams + OOP Problem Set (30–45 min each)

Each problem is designed to be solvable in **30–45 minutes** using:
- Clean OOP design (entities, services, enums)
- Java Streams for processing collections of events / data

---

## 1. Food Delivery Order Tracking (Medium)

### Scenario
You model a Swiggy/Zomato-type system with a fixed status flow:

`RECEIVED → ACCEPTED → PREPARING → PICKED_UP → DELIVERED`

Orders receive status updates over time. You must validate transitions and categorize orders.

### OOP Focus
- **Classes:** `Order`, `OrderStatus` (enum), `Restaurant`, `DeliveryAgent`, `OrderService`
- **Behavior:**
    - `updateStatus(orderId, newStatus)`
    - Validate that no status is skipped and you can only move forward in the flow.
    - Track list of status updates per order.

### Task
From a list of time-ordered status updates, determine:
1. Orders successfully delivered
2. Orders still in progress and their current stage
3. Orders with invalid transitions (first invalid transition info)

### Input

**ORDERS:**

- O1, Restaurant R1
- O2, Restaurant R1
- O3, Restaurant R2

**STATUS UPDATES (time-ordered):**

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
- O3, PICKED_UP   _(invalid: skipped PREPARING)_

### Expected Output (conceptual)

**Delivered Orders:**

- O1

**In-Progress Orders:**

- O2 → PREPARING

**Invalid Orders:**

- O3 → Invalid transition ACCEPTED → PICKED_UP

---

## 2. Online Examination Attempt Tracker (Medium)

### Scenario
You model an online exam platform where each exam attempt passes through:

`REGISTERED → STARTED → SUBMITTED → EVALUATED → RESULT_PUBLISHED`

Attempts receive state updates as the student progresses.

### OOP Focus
- **Classes:** `ExamAttempt`, `ExamStatus` (enum), `Student`, `ExamService`
- **Behavior:**
    - `updateStatus(attemptId, newStatus)`
    - Ensure transitions follow order without skipping.

### Task
From status update logs, determine:
1. Attempts successfully completed (RESULT_PUBLISHED)
2. Attempts still in progress and their current status
3. Attempts with invalid state transitions

### Input

**ATTEMPTS:**

- A1, Student S1
- A2, Student S2

**STATUS UPDATES:**

- A1, REGISTERED
- A1, STARTED
- A1, SUBMITTED
- A1, EVALUATED
- A1, RESULT_PUBLISHED

- A2, REGISTERED
- A2, SUBMITTED  _(invalid: skipped STARTED)_

### Expected Output

**Completed Attempts:**

- A1

**In-Progress Attempts:**

- None

**Invalid Attempts:**

- A2 → Invalid transition REGISTERED → SUBMITTED

---

## 3. Software Bug Lifecycle Tracker (Medium)

### Scenario
You track software bug lifecycle in an issue tracker. The allowed flow is:

`REPORTED → TRIAGED → ASSIGNED → IN_PROGRESS → FIXED → VERIFIED → CLOSED`

Developers update bug status as they work.

### OOP Focus
- **Classes:** `Bug`, `BugStatus` (enum), `Developer`, `BugService`
- **Behavior:**
    - Validate forward-only movement through statuses.

### Task
From bug status updates:
1. Show bugs that are successfully CLOSED
2. Show bugs that are still in progress with current status
3. Show bugs that have invalid transitions

### Input

**BUGS:**

- B1, Module "Login"
- B2, Module "Payment"

**STATUS UPDATES:**

- B1, REPORTED
- B1, TRIAGED
- B1, ASSIGNED
- B1, IN_PROGRESS
- B1, FIXED
- B1, VERIFIED
- B1, CLOSED

- B2, REPORTED
- B2, IN_PROGRESS  _(invalid: skipped TRIAGED, ASSIGNED)_

### Expected Output

**Closed Bugs:**

- B1

**In-Progress Bugs:**

- None

**Invalid Bugs:**

- B2 → Invalid transition REPORTED → IN_PROGRESS

---

## 4. Bank Loan Approval Workflow (Medium)

### Scenario
A bank processes loans via stages:

`APPLIED → DOCUMENT_VERIFIED → CREDIT_CHECKED → APPROVED → DISBURSED`

Loan records receive state changes.

### OOP Focus
- **Classes:** `LoanApplication`, `Customer`, `LoanStatus` (enum), `LoanService`
- **Behavior:** Validate proper state transitions.

### Task
From loan status updates:
1. List loans that reached DISBURSED
2. List loans in progress and their latest status
3. List loans with invalid transitions

### Input

**LOANS:**

- L1, Customer C1
- L2, Customer C2

**STATUS UPDATES:**

- L1, APPLIED
- L1, DOCUMENT_VERIFIED
- L1, CREDIT_CHECKED
- L1, APPROVED
- L1, DISBURSED

- L2, APPLIED
- L2, APPROVED  _(invalid: skipped DOCUMENT_VERIFIED, CREDIT_CHECKED)_

### Expected Output

**Completed Loans:**

- L1

**In-Progress Loans:**

- None

**Invalid Loans:**

- L2 → Invalid transition APPLIED → APPROVED

---

## 5. Airline Passenger Journey Tracker (Medium)

### Scenario
Passengers must pass through airport journey stages:

`CHECK_IN → SECURITY → IMMIGRATION → BOARDING → IN_FLIGHT`

### OOP Focus
- **Classes:** `Passenger`, `Flight`, `JourneyStatus` (enum), `JourneyService`
- **Behavior:** Verify correct journey sequence.

### Task
From journey logs:
1. Passengers who reached IN_FLIGHT
2. Passengers still mid-journey and their stage
3. Passengers with invalid transitions

### Input

**PASSENGERS:**

- P1, Flight F101
- P2, Flight F101

**STATUS UPDATES:**

- P1, CHECK_IN
- P1, SECURITY
- P1, IMMIGRATION
- P1, BOARDING
- P1, IN_FLIGHT

- P2, CHECK_IN
- P2, IMMIGRATION  _(invalid: skipped SECURITY)_

### Expected Output

**In-Flight Passengers:**

- P1

**In-Progress Passengers:**

- None

**Invalid Passengers:**

- P2 → Invalid transition CHECK_IN → IMMIGRATION

---

## 6. E-Commerce Return Request Workflow (Medium)

### Scenario
Customers raise return requests that must follow:

`REQUESTED → PICKUP_SCHEDULED → ITEM_COLLECTED → REFUND_INITIATED → REFUND_COMPLETED`

### OOP Focus
- **Classes:** `ReturnRequest`, `Order`, `ReturnStatus` (enum), `ReturnService`
- **Behavior:** Ensure no illegal skipping.

### Task
Using status updates:
1. List completed returns
2. List returns still in process
3. List invalid return flows

### Input

**RETURNS:**

- R1, Order O1
- R2, Order O2

**STATUS UPDATES:**

- R1, REQUESTED
- R1, PICKUP_SCHEDULED
- R1, ITEM_COLLECTED
- R1, REFUND_INITIATED
- R1, REFUND_COMPLETED

- R2, REQUESTED
- R2, REFUND_INITIATED  _(invalid)_

### Expected Output

**Completed Returns:**

- R1

**In-Progress Returns:**

- None

**Invalid Returns:**

- R2 → Invalid transition REQUESTED → REFUND_INITIATED

---

## 7. Ride-Sharing Trip Flow (Medium)

### Scenario
In an Uber/Ola-like system, trip states are:

`REQUESTED → DRIVER_ASSIGNED → PICKED_UP → IN_PROGRESS → COMPLETED`

### OOP Focus
- **Classes:** `Trip`, `Rider`, `Driver`, `TripStatus` (enum), `TripService`
- **Behavior:** Maintain per-trip ordered statuses.

### Task
From logs:
1. Identify completed trips
2. Show trips currently in progress and their stage
3. Mark trips with invalid flow

### Input

**TRIPS:**

- T1, Rider U1
- T2, Rider U2

**STATUS UPDATES:**

- T1, REQUESTED
- T1, DRIVER_ASSIGNED
- T1, PICKED_UP
- T1, IN_PROGRESS
- T1, COMPLETED

- T2, REQUESTED
- T2, PICKED_UP  _(invalid: skipped DRIVER_ASSIGNED)_

### Expected Output

**Completed Trips:**

- T1

**In-Progress Trips:**

- None

**Invalid Trips:**

- T2 → Invalid transition REQUESTED → PICKED_UP

---

## 8. Customer Support Ticket Lifecycle (Medium)

### Scenario
Support tickets move through:

`CREATED → ASSIGNED → IN_PROGRESS → RESOLVED → CLOSED`

### OOP Focus
- **Classes:** `Ticket`, `Agent`, `TicketStatus` (enum), `TicketService`
- **Behavior:** Transition validation.

### Task
Using ticket updates:
1. Show tickets that reached CLOSED
2. Show tickets in progress with their status
3. Show tickets with invalid transitions

### Input

**TICKETS:**

- K1, Category: Billing
- K2, Category: Technical

**STATUS UPDATES:**

- K1, CREATED
- K1, ASSIGNED
- K1, IN_PROGRESS
- K1, RESOLVED
- K1, CLOSED

- K2, CREATED
- K2, RESOLVED  _(invalid: skipped ASSIGNED, IN_PROGRESS)_

### Expected Output

**Closed Tickets:**

- K1

**In-Progress Tickets:**

- None

**Invalid Tickets:**

- K2 → Invalid transition CREATED → RESOLVED

---

## 9. Restaurant Table Reservation Status (Medium)

### Scenario
Reservations follow:

`REQUESTED → CONFIRMED → SEATED → SERVED → COMPLETED`

### OOP Focus
- **Classes:** `Reservation`, `Table`, `ReservationStatus` (enum), `ReservationService`

### Task
From reservation status list:
1. Reservations that completed (COMPLETED)
2. Reservations in progress
3. Reservations with invalid sequence

### Input

**RESERVATIONS:**

- RS1, Table T1
- RS2, Table T2

**STATUS UPDATES:**

- RS1, REQUESTED
- RS1, CONFIRMED
- RS1, SEATED
- RS1, SERVED
- RS1, COMPLETED

- RS2, REQUESTED
- RS2, SEATED  _(invalid: skipped CONFIRMED)_

### Expected Output

**Completed Reservations:**

- RS1

**In-Progress Reservations:**

- None

**Invalid Reservations:**

- RS2 → Invalid transition REQUESTED → SEATED

---

## 10. Hotel Room Booking Lifecycle (Medium)

### Scenario
Hotel bookings go through:

`BOOKED → CHECKED_IN → OCCUPIED → CHECKED_OUT → CLOSED`

### OOP Focus
- **Classes:** `Booking`, `Guest`, `BookingStatus` (enum), `BookingService`

### Task
From booking status updates:
1. Completed stays (CLOSED)
2. Ongoing stays
3. Invalid booking flows

### Input

**BOOKINGS:**

- B1, Room 101
- B2, Room 204

**STATUS UPDATES:**

- B1, BOOKED
- B1, CHECKED_IN
- B1, OCCUPIED
- B1, CHECKED_OUT
- B1, CLOSED

- B2, BOOKED
- B2, OCCUPIED  _(invalid: skipped CHECKED_IN)_

### Expected Output

**Completed Bookings:**

- B1

**In-Progress Bookings:**

- None

**Invalid Bookings:**

- B2 → Invalid transition BOOKED → OCCUPIED

---

## 11. University Admission Pipeline (Medium)

### Scenario
An admission application flows as:

`APPLIED → DOCUMENT_SUBMITTED → VERIFIED → ADMITTED → ENROLLED`

### OOP Focus
- **Classes:** `Application`, `Applicant`, `AdmissionStatus` (enum), `AdmissionService`

### Task
From application logs:
1. Applicants who reached ENROLLED
2. Applicants still in pipeline
3. Applications with invalid transitions

### Input

**APPLICATIONS:**

- A1, Applicant John
- A2, Applicant Mary

**STATUS UPDATES:**

- A1, APPLIED
- A1, DOCUMENT_SUBMITTED
- A1, VERIFIED
- A1, ADMITTED
- A1, ENROLLED

- A2, APPLIED
- A2, VERIFIED  _(invalid)_

### Expected Output

**Enrolled Applicants:**

- A1

**In-Progress Applicants:**

- None

**Invalid Applications:**

- A2 → Invalid transition APPLIED → VERIFIED

---

## 12. Movie Ticket Booking Workflow (Medium)

### Scenario
You track movie booking lifecycle:

`INITIATED → PAYMENT_PENDING → CONFIRMED → TICKET_GENERATED → USED`

### OOP Focus
- **Classes:** `MovieBooking`, `User`, `BookingStatus` (enum), `BookingService`

### Task
From status updates:
1. Show bookings with tickets used
2. Show bookings in progress
3. Show invalid booking lifecycles

### Input

**BOOKINGS:**

- M1, User U1
- M2, User U2

**STATUS UPDATES:**

- M1, INITIATED
- M1, PAYMENT_PENDING
- M1, CONFIRMED
- M1, TICKET_GENERATED
- M1, USED

- M2, INITIATED
- M2, CONFIRMED  _(invalid)_

### Expected Output

**Used Bookings:**

- M1

**In-Progress Bookings:**

- None

**Invalid Bookings:**

- M2 → Invalid transition INITIATED → CONFIRMED

---

## 13. Bank ATM Transaction Flow (Medium)

### Scenario
ATM transactions go through:

`INITIATED → PIN_VALIDATED → AMOUNT_ENTERED → DISPENSED → COMPLETED`

### OOP Focus
- **Classes:** `ATMTransaction`, `Account`, `ATMStatus` (enum), `ATMService`

### Task
From transaction updates:
1. Successfully completed ATM transactions
2. Incomplete ones and current stage
3. Invalid flows

### Input

**TRANSACTIONS:**

- TX1, Account A1
- TX2, Account A2

**STATUS UPDATES:**

- TX1, INITIATED
- TX1, PIN_VALIDATED
- TX1, AMOUNT_ENTERED
- TX1, DISPENSED
- TX1, COMPLETED

- TX2, INITIATED
- TX2, DISPENSED  _(invalid)_

### Expected Output

**Completed Transactions:**

- TX1

**Invalid Transactions:**

- TX2 → Invalid transition INITIATED → DISPENSED

---

## 14. Train Reservation Lifecycle (Medium)

### Scenario
Train reservations follow:

`REQUESTED → WAITLISTED/CONFIRMED → CHART_PREPARED → BOARDED → COMPLETED`

(For simplicity, only CONFIRMED branch is used in input.)

### OOP Focus
- **Classes:** `TrainReservation`, `Passenger`, `ReservationStatus` (enum), `ReservationService`

### Task
Determine:
1. Completed journeys
2. Ongoing reservations
3. Invalid flows

### Input

**RESERVATIONS:**

- TR1, Passenger P1
- TR2, Passenger P2

**STATUS UPDATES:**

- TR1, REQUESTED
- TR1, CONFIRMED
- TR1, CHART_PREPARED
- TR1, BOARDED
- TR1, COMPLETED

- TR2, REQUESTED
- TR2, BOARDED  _(invalid)_

### Expected Output

**Completed Journeys:**

- TR1

**Invalid Reservations:**

- TR2 → Invalid transition REQUESTED → BOARDED

---

## 15. Inventory Refill Cycle (Medium)

### Scenario
Inventory refill for products:

`REQUESTED → APPROVED → ORDER_PLACED → RECEIVED → STOCK_UPDATED`

### OOP Focus
- **Classes:** `RefillRequest`, `Product`, `RefillStatus` (enum), `InventoryService`

### Task
From refill status logs:
1. Refill requests that completed
2. Refill requests in progress
3. Invalid transitions

### Input

**REFILLS:**

- RF1, Product P1
- RF2, Product P2

**STATUS UPDATES:**

- RF1, REQUESTED
- RF1, APPROVED
- RF1, ORDER_PLACED
- RF1, RECEIVED
- RF1, STOCK_UPDATED

- RF2, REQUESTED
- RF2, RECEIVED  _(invalid)_

### Expected Output

**Completed Refills:**

- RF1

**Invalid Refills:**

- RF2 → Invalid transition REQUESTED → RECEIVED

---

## 16. Insurance Claim Processing (Medium)

### Scenario
Claims move through:

`RAISED → DOCUMENTS_SUBMITTED → UNDER_REVIEW → APPROVED → PAID`

### OOP Focus
- **Classes:** `Claim`, `PolicyHolder`, `ClaimStatus` (enum), `ClaimService`

### Task
From claim updates:
1. Claims that reached PAID
2. Claims under processing
3. Claims with invalid jumps

### Input

**CLAIMS:**

- C1, PolicyHolder H1
- C2, PolicyHolder H2

**STATUS UPDATES:**

- C1, RAISED
- C1, DOCUMENTS_SUBMITTED
- C1, UNDER_REVIEW
- C1, APPROVED
- C1, PAID

- C2, RAISED
- C2, APPROVED  _(invalid)_

### Expected Output

**Paid Claims:**

- C1

**Invalid Claims:**

- C2 → Invalid transition RAISED → APPROVED

---

## 17. Software Release Pipeline (Medium/Hard)

### Scenario
A CI/CD pipeline for releases:

`PLANNED → DEVELOPED → BUILT → TESTED → DEPLOYED → MONITORED`

### OOP Focus
- **Classes:** `Release`, `ReleaseStatus` (enum), `ReleaseService`
- **Additional:** release version, environment (dev/stage/prod)

### Task
From release events:
1. Releases fully DEPLOYED and MONITORED
2. Releases still in the pipeline
3. Releases with invalid transition(s)

### Input

**RELEASES:**

- RLS1, Version 1.0
- RLS2, Version 1.1

**STATUS UPDATES:**

- RLS1, PLANNED
- RLS1, DEVELOPED
- RLS1, BUILT
- RLS1, TESTED
- RLS1, DEPLOYED
- RLS1, MONITORED

- RLS2, PLANNED
- RLS2, BUILT  _(invalid: skipped DEVELOPED)_

### Expected Output

**Successfully Deployed:**

- RLS1

**Invalid Releases:**

- RLS2 → Invalid transition PLANNED → BUILT

---

## 18. Warehouse Packing Flow (Medium)

### Scenario
Orders in a warehouse are packed as:

`PICK_LIST_GENERATED → ITEMS_PICKED → PACKED → LABELLED → HANDED_OVER`

### OOP Focus
- **Classes:** `WarehouseOrder`, `PackingStatus` (enum), `WarehouseService`

### Task
From process logs:
1. Orders handed over to courier
2. Orders mid-process
3. Invalid flows

### Input

**ORDERS:**

- W1
- W2

**STATUS UPDATES:**

- W1, PICK_LIST_GENERATED
- W1, ITEMS_PICKED
- W1, PACKED
- W1, LABELLED
- W1, HANDED_OVER

- W2, PICK_LIST_GENERATED
- W2, PACKED  _(invalid)_

### Expected Output

**Handed Over:**

- W1

**Invalid Warehouse Orders:**

- W2 → Invalid transition PICK_LIST_GENERATED → PACKED

---

## 19. Cloud Resource Provisioning (Medium/Hard)

### Scenario
Cloud resources are provisioned through:

`REQUESTED → APPROVED → PROVISIONING → ACTIVE → DECOMMISSIONED`

### OOP Focus
- **Classes:** `CloudResourceRequest`, `ResourceType`, `ProvisionStatus` (enum), `ProvisionService`

### Task
From provisioning logs:
1. Resources that are ACTIVE
2. Resources DECOMMISSIONED
3. Invalid provisioning sequences

### Input

**REQUESTS:**

- CR1, VM
- CR2, Database

**STATUS UPDATES:**

- CR1, REQUESTED
- CR1, APPROVED
- CR1, PROVISIONING
- CR1, ACTIVE

- CR2, REQUESTED
- CR2, PROVISIONING  _(invalid: skipped APPROVED)_

### Expected Output

**Active Resources:**

- CR1

**Invalid Requests:**

- CR2 → Invalid transition REQUESTED → PROVISIONING

---

## 20. Online Exam Submission & Evaluation (Medium)

### Scenario
Assignment submission flow:

`ASSIGNED → STARTED → SUBMITTED → AUTO_EVALUATED → REVIEWED → GRADED`

### OOP Focus
- **Classes:** `AssignmentSubmission`, `Student`, `SubmissionStatus` (enum), `SubmissionService`

### Task
From submission logs:
1. Submissions fully GRADED
2. Submissions still in progress
3. Invalid flows

### Input

**SUBMISSIONS:**

- S1, Student X
- S2, Student Y

**STATUS UPDATES:**

- S1, ASSIGNED
- S1, STARTED
- S1, SUBMITTED
- S1, AUTO_EVALUATED
- S1, REVIEWED
- S1, GRADED

- S2, ASSIGNED
- S2, SUBMITTED  _(invalid: skipped STARTED)_

### Expected Output

**Graded Submissions:**

- S1

**Invalid Submissions:**

- S2 → Invalid transition ASSIGNED → SUBMITTED

---

## 21. Travel Itinerary Validation (Medium/Hard)

### Scenario
An international trip itinerary for a traveler:

`BOOKED → VISA_CHECKED → CHECKED_IN → DEPARTED → ARRIVED → COMPLETED`

### OOP Focus
- **Classes:** `Itinerary`, `Traveler`, `ItineraryStatus` (enum), `ItineraryService`

### Task
From status updates:
1. Itineraries COMPLETED
2. Ongoing itineraries
3. Invalid transitions

### Input

**ITINERARIES:**

- IT1, Traveler T1
- IT2, Traveler T2

**STATUS UPDATES:**

- IT1, BOOKED
- IT1, VISA_CHECKED
- IT1, CHECKED_IN
- IT1, DEPARTED
- IT1, ARRIVED
- IT1, COMPLETED

- IT2, BOOKED
- IT2, CHECKED_IN  _(invalid: skipped VISA_CHECKED)_

### Expected Output

**Completed Itineraries:**

- IT1

**Invalid Itineraries:**

- IT2 → Invalid transition BOOKED → CHECKED_IN

---

## 22. Gaming Level Progression Tracker (Medium)

### Scenario
A game's campaign mode:

`LEVEL1 → LEVEL2 → LEVEL3 → LEVEL4 → BOSS_FIGHT → COMPLETED`

### OOP Focus
- **Classes:** `GameProfile`, `LevelStatus` (enum or enum-like), `GameService`

### Task
From level completion events:
1. Players who completed the game
2. Players mid-way and their highest completed level
3. Players with invalid jumps (e.g., LEVEL1 → LEVEL3)

### Input

**PLAYERS:**

- GP1, Player A
- GP2, Player B

**STATUS UPDATES:**

- GP1, LEVEL1
- GP1, LEVEL2
- GP1, LEVEL3
- GP1, LEVEL4
- GP1, BOSS_FIGHT
- GP1, COMPLETED

- GP2, LEVEL1
- GP2, LEVEL3  _(invalid)_

### Expected Output

**Completed Profiles:**

- GP1

**Invalid Profiles:**

- GP2 → Invalid transition LEVEL1 → LEVEL3

---

## 23. IoT Device Setup Flow (Medium)

### Scenario
Smart device setup:

`POWERED_ON → CONNECTING_WIFI → WIFI_CONNECTED → REGISTERED → ACTIVE`

### OOP Focus
- **Classes:** `Device`, `DeviceStatus` (enum), `DeviceSetupService`

### Task
From status logs:
1. Devices that reached ACTIVE
2. Devices still setting up
3. Devices with invalid flow

### Input

**DEVICES:**

- D1, Smart Bulb
- D2, Smart Camera

**STATUS UPDATES:**

- D1, POWERED_ON
- D1, CONNECTING_WIFI
- D1, WIFI_CONNECTED
- D1, REGISTERED
- D1, ACTIVE

- D2, POWERED_ON
- D2, WIFI_CONNECTED  _(invalid)_

### Expected Output

**Active Devices:**

- D1

**Invalid Devices:**

- D2 → Invalid transition POWERED_ON → WIFI_CONNECTED

---

## 24. Manufacturing Assembly Line Tracking (Medium/Hard)

### Scenario
Product assembly:

`RAW → PARTS_FITTED → ASSEMBLED → QUALITY_CHECK → PACKED → DISPATCHED`

### OOP Focus
- **Classes:** `AssemblyItem`, `AssemblyStatus` (enum), `AssemblyService`

### Task
From assembly logs:
1. Items dispatched
2. Items still in process
3. Items with invalid status sequence

### Input

**ITEMS:**

- AIT1
- AIT2

**STATUS UPDATES:**

- AIT1, RAW
- AIT1, PARTS_FITTED
- AIT1, ASSEMBLED
- AIT1, QUALITY_CHECK
- AIT1, PACKED
- AIT1, DISPATCHED

- AIT2, RAW
- AIT2, ASSEMBLED  _(invalid)_

### Expected Output

**Dispatched Items:**

- AIT1

**Invalid Items:**

- AIT2 → Invalid transition RAW → ASSEMBLED

---

## 25. Call Center Ticket Handling (Medium)

### Scenario
Call center workflow:

`OPENED → IN_PROGRESS → WAITING_CUSTOMER → RESOLVED → CLOSED`

### OOP Focus
- **Classes:** `CallTicket`, `Agent`, `CallStatus` (enum), `CallService`

### Task
From ticket logs:
1. Tickets CLOSED
2. Tickets still open and current state
3. Tickets with invalid jumps

### Input

**CALL TICKETS:**

- CT1
- CT2

**STATUS UPDATES:**

- CT1, OPENED
- CT1, IN_PROGRESS
- CT1, WAITING_CUSTOMER
- CT1, RESOLVED
- CT1, CLOSED

- CT2, OPENED
- CT2, RESOLVED  _(invalid)_

### Expected Output

**Closed Call Tickets:**

- CT1

**Invalid Call Tickets:**

- CT2 → Invalid transition OPENED → RESOLVED

---

## 26. Customs Clearance Process (Medium/Hard)

### Scenario
Imported shipment clearance:

`ARRIVED → DOCUMENT_VERIFICATION → DUTY_ASSESSMENT → DUTY_PAID → CLEARED`

### OOP Focus
- **Classes:** `Shipment`, `CustomsStatus` (enum), `CustomsService`

### Task
From clearance status logs:
1. Shipments CLEARED
2. Shipments in process
3. Invalid customs flows

### Input

**SHIPMENTS:**

- SH1
- SH2

**STATUS UPDATES:**

- SH1, ARRIVED
- SH1, DOCUMENT_VERIFICATION
- SH1, DUTY_ASSESSMENT
- SH1, DUTY_PAID
- SH1, CLEARED

- SH2, ARRIVED
- SH2, DUTY_PAID  _(invalid)_

### Expected Output

**Cleared Shipments:**

- SH1

**Invalid Shipments:**

- SH2 → Invalid transition ARRIVED → DUTY_PAID

---

## 27. Drone Delivery Route Flow (Medium/Hard)

### Scenario
Drone delivery stages:

`LAUNCHED → EN_ROUTE → NEAR_DESTINATION → DELIVERED → RETURNING → LANDED`

### OOP Focus
- **Classes:** `DroneDelivery`, `Drone`, `DroneStatus` (enum), `DroneService`

### Task
From drone logs:
1. Deliveries successfully completed (DELIVERED and LANDED)
2. Deliveries currently in progress
3. Deliveries with invalid jumps

### Input

**DELIVERIES:**

- DD1
- DD2

**STATUS UPDATES:**

- DD1, LAUNCHED
- DD1, EN_ROUTE
- DD1, NEAR_DESTINATION
- DD1, DELIVERED
- DD1, RETURNING
- DD1, LANDED

- DD2, LAUNCHED
- DD2, DELIVERED  _(invalid)_

### Expected Output

**Completed Drone Deliveries:**

- DD1

**Invalid Drone Deliveries:**

- DD2 → Invalid transition LAUNCHED → DELIVERED

---

## 28. Payment Gateway Authorization Flow (Medium/Hard)

### Scenario
Online payment transaction flow:

`INITIATED → REDIRECTED_TO_BANK → OTP_VALIDATED → AUTHORIZED → CAPTURED → SETTLED`

### OOP Focus
- **Classes:** `PaymentTransaction`, `PaymentStatus` (enum), `PaymentService`

### Task
Using transaction logs:
1. Payments successfully SETTLED
2. Transactions in intermediate states
3. Transactions with invalid transitions

### Input

**TRANSACTIONS:**

- PG1
- PG2

**STATUS UPDATES:**

- PG1, INITIATED
- PG1, REDIRECTED_TO_BANK
- PG1, OTP_VALIDATED
- PG1, AUTHORIZED
- PG1, CAPTURED
- PG1, SETTLED

- PG2, INITIATED
- PG2, AUTHORIZED  _(invalid)_

### Expected Output

**Settled Payments:**

- PG1

**Invalid Payments:**

- PG2 → Invalid transition INITIATED → AUTHORIZED

---

## 29. Smart City Traffic Violation Processing (Medium/Hard)

### Scenario
Traffic violation lifecycle:

`CAPTURED → VEHICLE_IDENTIFIED → NOTICE_GENERATED → NOTICE_SENT → PAID → CLOSED`

### OOP Focus
- **Classes:** `ViolationCase`, `Vehicle`, `ViolationStatus` (enum), `TrafficService`

### Task
From violation logs:
1. Cases CLOSED
2. Cases where notice is pending or payment pending
3. Invalid flows

### Input

**CASES:**

- VC1
- VC2

**STATUS UPDATES:**

- VC1, CAPTURED
- VC1, VEHICLE_IDENTIFIED
- VC1, NOTICE_GENERATED
- VC1, NOTICE_SENT
- VC1, PAID
- VC1, CLOSED

- VC2, CAPTURED
- VC2, NOTICE_SENT  _(invalid)_

### Expected Output

**Closed Violation Cases:**

- VC1

**Invalid Cases:**

- VC2 → Invalid transition CAPTURED → NOTICE_SENT

---

## 30. Employee Onboarding Workflow (Medium)

### Scenario
New employee onboarding steps:

`OFFER_ACCEPTED → DOCUMENTS_SUBMITTED → BACKGROUND_CHECK → ONBOARDING_SESSION → ACTIVE_EMPLOYEE`

### OOP Focus
- **Classes:** `EmployeeOnboarding`, `Employee`, `OnboardingStatus` (enum), `OnboardingService`

### Task
From onboarding logs:
1. Employees who reached ACTIVE_EMPLOYEE
2. Employees in onboarding stages
3. Onboarding flows with invalid transitions

### Input

**ONBOARDING RECORDS:**

- OB1, Employee E1
- OB2, Employee E2

**STATUS UPDATES:**

- OB1, OFFER_ACCEPTED
- OB1, DOCUMENTS_SUBMITTED
- OB1, BACKGROUND_CHECK
- OB1, ONBOARDING_SESSION
- OB1, ACTIVE_EMPLOYEE

- OB2, OFFER_ACCEPTED
- OB2, BACKGROUND_CHECK  _(invalid)_

### Expected Output

**Active Employees:**

- OB1

**Invalid Onboarding Flows:**

- OB2 → Invalid transition OFFER_ACCEPTED → BACKGROUND_CHECK

---
