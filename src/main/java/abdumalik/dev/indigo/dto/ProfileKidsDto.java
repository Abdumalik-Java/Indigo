package abdumalik.dev.indigo.dto;

import abdumalik.dev.indigo.model.entity.Gender;
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
public class ProfileKidsDto {

    private UUID photoId;
    private UUID groupId;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate birthday;
    private UUID addressId;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}