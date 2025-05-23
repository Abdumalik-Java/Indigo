package abdumalik.dev.indigo.dto;

import abdumalik.dev.indigo.model.entity.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String firstName;
    private String lastName;
    private String username;
    private Integer age;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}