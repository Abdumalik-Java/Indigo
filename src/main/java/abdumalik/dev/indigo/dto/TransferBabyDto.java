package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferBabyDto {

    private UUID profileKidsId;
    private LocalDate period;
    private String title;
    private UUID groupId;

}