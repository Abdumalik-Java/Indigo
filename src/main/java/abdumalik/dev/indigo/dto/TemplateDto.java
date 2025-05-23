package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateDto {

    private String name;
    private String description;
    private String status;
    private UUID photoId;
    private UUID iconId;

}