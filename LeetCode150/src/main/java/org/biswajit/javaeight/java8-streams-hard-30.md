
# Java 8 Streams – 30 Very Hard Real-Life Interview Problems

This document contains **30 interview-grade, real-life problems** designed specifically
to test **deep understanding of Java 8 Streams**.

Each problem contains:
- A real-life **scenario**
- A **raw input dataset** (no model classes)
- A clear **expected output dataset**

You can directly use this file for **interview preparation or mock interviews**.

---

## Problem 1: Bank Transaction Risk Analyzer

### Scenario
Flag users whose **total failed transaction amount** is greater than their **total successful transaction amount**.

### Input Dataset
```
user=A amount=100 success=true
user=A amount=200 success=false
user=A amount=300 success=false
user=B amount=500 success=true
user=B amount=100 success=false
```

### Output
```
[A]
```

---

## Problem 2: Employee Burnout Detection

### Scenario
An employee is burned out if they work **more than 60 hours for 3 consecutive weeks**.

### Input Dataset
```
emp=E1 week=1 hours=65
emp=E1 week=2 hours=70
emp=E1 week=3 hours=62
emp=E2 week=1 hours=61
emp=E2 week=2 hours=55
emp=E2 week=3 hours=70
```

### Output
```
[E1]
```

---

## Problem 3: E-Commerce Fraud Basket Detection

### Scenario
A customer is suspicious if they purchase the **same product from 3 or more sellers on the same day**.

### Input Dataset
```
customer=C1 product=P1 seller=S1 date=2025-01-01
customer=C1 product=P1 seller=S2 date=2025-01-01
customer=C1 product=P1 seller=S3 date=2025-01-01
customer=C2 product=P2 seller=S1 date=2025-01-01
```

### Output
```
[C1]
```

---

## Problem 4: Stock Volume Spike Detector

### Scenario
A stock is flagged if **today’s volume is more than twice the average volume of the previous 30 days**.

### Input Dataset
```
Stock=ABC
Last30DaysVolumes=[900,1000,1100,950,1050]
TodayVolume=2500
```

### Output
```
[ABC]
```

---

## Problem 5: Ride-Sharing Surge Abuse

### Scenario
Drivers who cancel **more than 40% of surge-priced rides** should be flagged.

### Input Dataset
```
driver=D1 surge=true canceled=true
driver=D1 surge=true canceled=true
driver=D1 surge=true canceled=false
driver=D2 surge=true canceled=false
```

### Output
```
[D1]
```

---

## Problem 6: OTT Binge-Watch Detection

### Scenario
Users watching **more than 8 hours of the same genre in a single day**.

### Input Dataset
```
user=U1 genre=Drama minutes=300 date=2025-01-01
user=U1 genre=Drama minutes=250 date=2025-01-01
user=U1 genre=Drama minutes=100 date=2025-01-01
user=U2 genre=Comedy minutes=200 date=2025-01-01
```

### Output
```
[U1]
```

---

## Problem 7: Aadhaar–PAN Duplication Detection

### Scenario
Detect Aadhaar numbers linked with **more than one PAN**.

### Input Dataset
```
PAN=PAN1 Aadhaar=A1
PAN=PAN2 Aadhaar=A1
PAN=PAN3 Aadhaar=A2
```

### Output
```
[A1]
```

---

## Problem 8: Logistics Delay Hotspots

### Scenario
Cities whose **average delivery delay** is higher than the **national average**.

### Input Dataset
```
city=Delhi delay=2
city=Delhi delay=3
city=Delhi delay=4
city=Mumbai delay=1
city=Mumbai delay=2
city=Mumbai delay=1
```

### Output
```
[Delhi]
```

---

## Problem 9: Payment Gateway Failure Pattern

### Scenario
Payment gateways with **3 consecutive failures**.

### Input Dataset
```
gateway=PG1 success=false
gateway=PG1 success=false
gateway=PG1 success=false
gateway=PG2 success=true
```

### Output
```
[PG1]
```

---

## Problem 10: Salary Compression Detector

### Scenario
A team is flagged if **any junior employee earns more than a senior employee**.

### Input Dataset
```
team=TeamX name=A level=3 salary=80000
team=TeamX name=B level=5 salary=70000
team=TeamY name=C level=4 salary=90000
```

### Output
```
[TeamX]
```

---

## Problem 11: Subscription Churn Predictor

### Scenario
Users missing **3 consecutive monthly payments**.

### Input Dataset
```
user=U1 month=Jan paid=false
user=U1 month=Feb paid=false
user=U1 month=Mar paid=false
user=U2 month=Jan paid=false
user=U2 month=Feb paid=true
```

### Output
```
[U1]
```

---

## Problem 12: Taxi Route Inefficiency Detector

### Scenario
Trips where **actual distance exceeds 1.5× the estimated distance**.

### Input Dataset
```
trip=T1 estimated=10 actual=18
trip=T2 estimated=12 actual=13
```

### Output
```
[T1]
```

---

## Problem 13: Hotel Overbooking Detection

### Scenario
A date is overbooked if **rooms booked exceed rooms available**.

### Input Dataset
```
date=2025-01-01 available=100 booked=120
date=2025-01-02 available=100 booked=90
```

### Output
```
[2025-01-01]
```

---

## Problem 14: App Crash Frequency Analyzer

### Scenario
Users whose apps crash **more than 5 times in a day**.

### Input Dataset
```
user=U1 crashes=6
user=U2 crashes=3
```

### Output
```
[U1]
```

---

## Problem 15: Attendance Fraud Detection

### Scenario
Students marked present but logged in for **less than 5 minutes**.

### Input Dataset
```
student=S1 present=true minutes=3
student=S2 present=true minutes=10
```

### Output
```
[S1]
```

---

## Problem 16: Telecom Call Drop Zones

### Scenario
Cell towers whose **call drop rate is higher than the regional average**.

### Input Dataset
```
tower=T1 drops=30 calls=100
tower=T2 drops=10 calls=100
```

### Output
```
[T1]
```

---

## Problem 17: Delivery Partner Load Imbalance

### Scenario
Delivery partners completing **more than twice the daily average orders**.

### Input Dataset
```
partner=P1 orders=40
partner=P2 orders=10
partner=P3 orders=10
```

### Output
```
[P1]
```

---

## Problem 18: OTT User Similarity Detection

### Scenario
Users with **90% or more overlap in watched content**.

### Input Dataset
```
U1=[M1,M2,M3,M4,M5]
U2=[M1,M2,M3,M4,M5]
U3=[M1,M2]
```

### Output
```
[(U1,U2)]
```

---

## Problem 19: Expense Claim Abuse

### Scenario
Employees claiming the **same amount more than 5 times**.

### Input Dataset
```
emp=E1 amount=5000
emp=E1 amount=5000
emp=E1 amount=5000
emp=E1 amount=5000
emp=E1 amount=5000
emp=E1 amount=5000
```

### Output
```
[E1]
```

---

## Problem 20: Restaurant Peak Hour Analyzer

### Scenario
Hours where orders spike **more than 150% compared to the previous hour**.

### Input Dataset
```
hour=18 orders=40
hour=19 orders=100
```

### Output
```
[19]
```

---

## Problem 21: File Access Security Breach

### Scenario
Users accessing **both public and restricted files in the same session**.

### Input Dataset
```
user=U1 file=public
user=U1 file=restricted
user=U2 file=public
```

### Output
```
[U1]
```

---

## Problem 22: Loan EMI Default Risk

### Scenario
Users missing **3 EMIs in the last 6 months**.

### Input Dataset
```
user=U1 month=Jan paid=false
user=U1 month=Feb paid=false
user=U1 month=Mar paid=false
```

### Output
```
[U1]
```

---

## Problem 23: Dead Inventory Detection

### Scenario
Products unsold for **more than 90 days**.

### Input Dataset
```
product=P1 lastSoldDaysAgo=120
product=P2 lastSoldDaysAgo=30
```

### Output
```
[P1]
```

---

## Problem 24: Code Commit Risk Analyzer

### Scenario
Large commits made **within 2 days of release**.

### Input Dataset
```
dev=D1 daysBeforeRelease=1 linesChanged=800
dev=D2 daysBeforeRelease=10 linesChanged=900
```

### Output
```
[D1]
```

---

## Problem 25: Traffic Violation Repeaters

### Scenario
Vehicles fined **more than 3 times in a month**.

### Input Dataset
```
vehicle=V1
vehicle=V1
vehicle=V1
vehicle=V1
vehicle=V2
```

### Output
```
[V1]
```

---

## Problem 26: Email Spam Network Detection

### Scenario
Users sending emails to **more than 1000 unique recipients in a day**.

### Input Dataset
```
user=U1 uniqueRecipients=1200
user=U2 uniqueRecipients=200
```

### Output
```
[U1]
```

---

## Problem 27: Gaming Bot Detection

### Scenario
Players executing **identical action sequences repeatedly**.

### Input Dataset
```
P1=[A,B,C,A,B,C]
P2=[A,B,C,A,B,C]
P3=[A,B]
```

### Output
```
[(P1,P2)]
```

---

## Problem 28: Prescription Abuse Detection

### Scenario
Same medicine prescribed by **3 different doctors to the same patient**.

### Input Dataset
```
patient=P1 doctor=D1 medicine=M1
patient=P1 doctor=D2 medicine=M1
patient=P1 doctor=D3 medicine=M1
```

### Output
```
[P1]
```

---

## Problem 29: Server Resource Hog Detection

### Scenario
Processes consuming **more than 70% CPU for over 10 minutes**.

### Input Dataset
```
process=P1 cpu=75 minutes=15
process=P2 cpu=60 minutes=20
```

### Output
```
[P1]
```

---

## Problem 30: Multi-Account Fraud Detection

### Scenario
Users sharing **the same device, IP, and payment method**.

### Input Dataset
```
user=U1 device=D1 ip=IP1 card=C1
user=U2 device=D1 ip=IP1 card=C1
```

### Output
```
[(U1,U2)]
```

---

END OF DOCUMENT
