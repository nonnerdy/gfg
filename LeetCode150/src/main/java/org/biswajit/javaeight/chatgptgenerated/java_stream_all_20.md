# Java Stream Hard Problems (Accenture Level)

## 1. Top N Customers by Spend
Problem: Find top 3 customers by total spend.

Input:
(1,200), (2,500), (1,300), (3,700), (2,100)

Output:
(3,700), (2,600), (1,500)

---

## 2. Fraud Detection
Problem: Find users with >3 transactions within 1 minute.

Input:
Transaction(userId, timestamp)

Output:
List of suspicious userIds

---

## 3. Highest Paid per Department
Problem: Find highest paid employee per department.

Input:
Employee(id, dept, salary)

Output:
IT -> Emp3, HR -> Emp5

---

## 4. Most Frequent Error Code
Problem: Find most frequent error code.

Input:
["500","404","500","403","500","404"]

Output:
500

---

## 5. Peak Ride Hour
Problem: Find hour with max rides.

Input:
Ride(timestamp)

Output:
18

---

## 6. Low Stock by Category
Problem: Group low stock products by category.

Input:
Product(name, category, stock)

Output:
Electronics -> [P1,P3]

---

## 7. Top K Hashtags
Problem: Find top 5 hashtags.

Input:
["#java","#ai","#java"]

Output:
["#java","#ai"]

---

## 8. Salary Band Distribution
Problem: Group employees into salary bands.

Output:
LOW, MID, HIGH counts

---

## 9. Duplicate Orders
Problem: Find duplicate order IDs.

Input:
[101,102,101,103,102]

Output:
[101,102]

---

## 10. Avg Order Value per Customer
Problem: Avg spend per customer.

Output:
1->250, 2->300

---

## 11. Running Balance
Problem: Compute running balance.

Input:
[100,-50,200]

Output:
[100,50,250]

---

## 12. Word Count
Input:
["error","warn","error"]

Output:
error:2, warn:1

---

## 13. Top 2 Students per Class
Input:
(A,10A,90),(B,10A,85),(C,10A,95)

Output:
10A -> [C,A]

---

## 14. Partition Orders
Input:
(1,DELIVERED),(2,PENDING)

Output:
true->[1], false->[2]

---

## 15. Max Profit per Stock
Input:
(AAPL,100),(AAPL,250)

Output:
AAPL->250

---

## 16. Longest Message per User
Input:
(A,"Hi"),(A,"Hello World")

Output:
A->"Hello World"

---

## 17. Moving Average
Input:
[10,20,30,40,50]

Output:
[10,15,20,30,40]

---

## 18. Unique Sorted Tags
Input:
["mobile","android","mobile"]

Output:
["android","mobile"]

---

## 19. Most Common Genre per Year
Input:
(2020,Action),(2020,Action),(2020,Comedy)

Output:
2020->Action

---

## 20. Slowest API per Service
Input:
(User,/login,200),(User,/register,350)

Output:
User->/register
