package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {

    private String title;
    private Integer iconId;
    private Integer orderIndex;
    private boolean active;

}