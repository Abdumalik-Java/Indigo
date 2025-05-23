package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisterRepo extends JpaRepository<Register, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);
}