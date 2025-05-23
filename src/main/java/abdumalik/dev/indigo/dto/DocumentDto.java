package abdumalik.dev.indigo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    private String documentType;
    private Integer seriaNumber;
    private Integer number;
    private String code;
    private LocalDate date;
    private boolean issuedBy;
    private UUID addressId;

}