package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceStatisticsDto {

    private LocalDate fromDate;
    private LocalDate toDate;
    private UUID groupId;
    private UUID profileId;

}