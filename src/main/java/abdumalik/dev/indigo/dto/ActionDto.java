package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {

    private LocalDate date;
    private UUID groupId;
    private LocalDate endDate;
    private String transferReason;

}