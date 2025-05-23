package abdumalik.dev.indigo.dto;

import abdumalik.dev.indigo.model.entity.CheckType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDto {

    private LocalDate fromDate;
    private LocalDate toDate;
    @Enumerated(EnumType.STRING)
    private CheckType checkType;
    private UUID groupId;
    private boolean paid;
    private boolean unpaid;
    private Double summa;
    private UUID profileId;

}