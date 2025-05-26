package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Employees;
import abdumalik.dev.indigo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeesRepo extends JpaRepository<Employees, UUID> {
    Optional<Employees> findByProfileId(Profile profileId);
    boolean existsByProfileId(UUID profileId);
}