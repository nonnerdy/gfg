package org.biswajit.javaeight.employeeworkloadanomalydetection;

import java.time.LocalDate;
import java.util.List;

public class WorkLoadDao {
    public static List<WorkLoad> getWorkLoads(){
        return List.of(

                // ✅ E1 – SHOULD be flagged (13 hrs, 2 projects, same day)
                new WorkLoad("E1", "P1", LocalDate.of(2024, 1, 10), 6),
                new WorkLoad("E1", "P2", LocalDate.of(2024, 1, 10), 7),

                // ❌ E2 – NOT flagged (12 hrs exactly)
                new WorkLoad("E2", "P1", LocalDate.of(2024, 1, 10), 12),

                // ❌ E3 – NOT flagged (13 hrs but single project)
                new WorkLoad("E3", "P3", LocalDate.of(2024, 1, 10), 13),

                // ❌ E4 – NOT flagged (multi-project but <= 12 hrs)
                new WorkLoad("E4", "P1", LocalDate.of(2024, 1, 10), 5),
                new WorkLoad("E4", "P2", LocalDate.of(2024, 1, 10), 6),

                // ❌ E5 – NOT flagged (hours split across days)
                new WorkLoad("E5", "P1", LocalDate.of(2024, 1, 10), 8),
                new WorkLoad("E5", "P2", LocalDate.of(2024, 1, 11), 6),

                // ✅ E6 – SHOULD be flagged (14 hrs, 3 projects)
                new WorkLoad("E6", "P1", LocalDate.of(2024, 1, 12), 5),
                new WorkLoad("E6", "P2", LocalDate.of(2024, 1, 12), 4),
                new WorkLoad("E6", "P3", LocalDate.of(2024, 1, 12), 5),

                // ❌ E7 – NOT flagged (multiple entries same project)
                new WorkLoad("E7", "P4", LocalDate.of(2024, 1, 13), 6),
                new WorkLoad("E7", "P4", LocalDate.of(2024, 1, 13), 7));
    }
}
