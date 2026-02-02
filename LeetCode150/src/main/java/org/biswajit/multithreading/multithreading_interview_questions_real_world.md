# Real-World Multithreading Interview Questions (Java)

This document contains **20 detailed, interview-ready multithreading questions**, curated from real-world systems.  
They are structured to test **correctness, coordination, performance, and system-level thinking**.

---

## 🟢 Level 1 — Core Multithreading (Correctness First)

### 1. Bank Account – Concurrent Updates
**Context:**  
A `BankAccount` object is shared across threads. Multiple threads call `deposit()` and `withdraw()` at the same time.

**Rules:**
- Balance starts with an initial value
- Withdraw should fail if balance is insufficient
- No updates should be lost

**Question:**  
How would you make this class thread-safe? Show code and explain whether you would use `synchronized`, `Lock`, or atomic variables.

---

### 2. Inventory Stock Management
**Context:**  
An e-commerce product has limited stock. Hundreds of order threads try to place orders simultaneously.

**Rules:**
- Stock must never go below zero
- Order should fail if stock is unavailable

**Question:**  
How do you implement this safely under concurrency? What race condition occurs if two threads read stock at the same time?

---

### 3. Unique Order ID Generator
**Context:**  
Every order must receive a unique, increasing order ID.

**Rules:**
- Method can be called concurrently
- No duplicate or skipped IDs

**Question:**  
How would you design `getNextOrderId()`? Would you use synchronization or `AtomicInteger`, and why?

---

### 4. Thread-Safe Logging System
**Context:**  
Multiple application threads write logs to the same file.

**Rules:**
- Log lines must not interleave
- Logging should not degrade application performance

**Question:**  
How do you make logging thread-safe? How would you optimize it for performance?

---

### 5. Single Printer, Multiple Clients
**Context:**  
One printer is shared by multiple users submitting print jobs.

**Rules:**
- Only one job can print at a time
- Jobs must not overlap

**Question:**  
How do you enforce exclusive access to the printer using multithreading constructs?

---

## 🟡 Level 2 — Thread Coordination & Communication

### 6. Producer–Consumer (Orders & Kitchen)
**Context:**  
Order threads produce orders. Kitchen threads consume and process them.

**Rules:**
- Shared queue has a fixed size
- Producer must wait if the queue is full
- Consumer must wait if the queue is empty

**Question:**  
How would you implement this using Java concurrency utilities? Why is busy waiting a bad idea?

---

### 7. Rider Waiting for Driver
**Context:**  
A rider requests a ride and waits until a driver is assigned.

**Rules:**
- Rider thread must block
- Rider resumes only when a driver becomes available

**Question:**  
How do you block and wake the rider thread safely?

---

### 8. Traffic Signal Controller
**Context:**  
A junction has 4 traffic signals, each controlled by a thread.

**Rules:**
- Only one signal can be GREEN at a time
- Signals rotate in a fixed order

**Question:**  
How do you coordinate these threads to enforce the rule?

---

### 9. Asynchronous Email Notification
**Context:**  
User registration should respond immediately. Email sending is slow.

**Rules:**
- Main flow must not block
- Email must be sent reliably

**Question:**  
How do you design this using `ExecutorService`?

---

### 10. Online Exam Auto-Submission
**Context:**  
An online exam has a strict time limit.

**Rules:**
- Exam must auto-submit exactly when time expires
- No busy waiting

**Question:**  
How do you implement this using Java’s scheduling utilities?

---

## 🟠 Level 3 — Performance & Scalability

### 11. Web Server Thread Model
**Context:**  
A web server handles thousands of concurrent requests.

**Rules:**
- System resources are limited
- Throughput and stability are critical

**Question:**  
Why is one-thread-per-request dangerous? What is the recommended threading model?

---

### 12. Parallel Image Processing
**Context:**  
Images must be resized, watermarked, and compressed.

**Rules:**
- CPU-intensive workload
- Large number of images

**Question:**  
How do you parallelize this efficiently without overwhelming the CPU?

---

### 13. Parallel Report Data Fetch
**Context:**  
A report depends on data from a database, cache, and external API.

**Rules:**
- Overall response time should be minimal
- All results are required

**Question:**  
How do you fetch all data concurrently and combine the results?

---

### 14. Handling Slow or Hanging APIs
**Context:**  
An external API sometimes hangs indefinitely.

**Rules:**
- System must not block forever
- Slow calls must be cancelled

**Question:**  
How do you enforce timeouts and handle thread interruption?

---

### 15. Large-Scale Batch Processing
**Context:**  
Millions of records must be processed nightly.

**Rules:**
- Must complete within a fixed time window
- Hardware resources must be fully utilized

**Question:**  
How do you divide work among threads for maximum throughput?

---

## 🔴 Level 4 — Advanced / System-Oriented

### 16. API Rate Limiter
**Context:**  
Each user can make at most 100 requests per minute.

**Rules:**
- Must be accurate under concurrency
- Low contention is required

**Question:**  
How do you implement a thread-safe rate limiter?

---

### 17. Deadlock Prevention
**Context:**  
Two threads acquire two shared resources.

**Rules:**
- Locks acquired in different order may cause deadlock

**Question:**  
Explain how deadlock occurs and how you prevent it in code.

---

### 18. Concurrent LRU Cache
**Context:**  
A shared cache is accessed by many threads.

**Rules:**
- Reads are frequent
- Eviction must be safe

**Question:**  
How do you design this for high read concurrency?

---

### 19. Order Matching Engine
**Context:**  
Buy and sell orders arrive concurrently.

**Rules:**
- Orders must be matched correctly
- Latency must be minimal

**Question:**  
How do you handle concurrency without heavy locking?

---

### 20. Circuit Breaker State Management
**Context:**  
Multiple threads call a downstream service.

**Rules:**
- Circuit transitions between CLOSED, OPEN, and HALF-OPEN
- State must be consistent across threads

**Question:**  
How do you manage circuit breaker state safely under concurrency?

---

## 📌 How to Practice

For each question:
1. Identify shared state
2. Explain the concurrency risk
3. Choose the right concurrency construct
4. Discuss trade-offs
5. Mention production considerations

---

**Use this document as a preparation guide for Java multithreading interviews at product companies.**