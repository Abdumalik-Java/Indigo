package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private String name;
    private Integer size;
    private String path;
    private String type;
    private String byteData;

}