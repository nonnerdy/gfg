package org.biswajit.javaeight.userswitincreasingpurchasetrens;

import java.time.LocalDate;
import java.util.List;

public class PurchaseData {
    public static List<Purchase> getPurchases() {
        return List.of(
                // Increasing trend ✅
                new Purchase("U1", LocalDate.of(2024, 1, 1), 200),
                new Purchase("U1", LocalDate.of(2024, 2, 1), 300),
                new Purchase("U1", LocalDate.of(2024, 3, 1), 500),

                // Decreasing trend ❌
                new Purchase("U2", LocalDate.of(2024, 1, 1), 400),
                new Purchase("U2", LocalDate.of(2024, 2, 1), 300),

                // Equal values ❌
                new Purchase("U3", LocalDate.of(2024, 1, 1), 200),
                new Purchase("U3", LocalDate.of(2024, 2, 1), 200),

                // Single purchase ❌
                new Purchase("U4", LocalDate.of(2024, 1, 1), 100));
    }
}
