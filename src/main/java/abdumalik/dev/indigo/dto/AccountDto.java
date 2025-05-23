package abdumalik.dev.indigo.dto;

import abdumalik.dev.indigo.model.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String phoneNumber;
    @Email
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}