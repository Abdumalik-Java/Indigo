package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {

    private UUID categoryId;
    private String priority;
    private UUID templateId;
    private UUID groupId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String title;
    private String description;

}