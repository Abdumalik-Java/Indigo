package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Account;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {
    boolean existsByEmailOrPhoneNumber(@Email String email, String phoneNumber);
}