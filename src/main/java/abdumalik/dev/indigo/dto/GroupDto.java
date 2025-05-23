package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private String name;
    private Integer groupNumber;
    private Integer groupYear;

}