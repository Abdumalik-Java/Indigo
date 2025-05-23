package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Employees;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RelativeRepo extends JpaRepository<Relative, UUID> {
    Optional<Relative> findByProfileId(Profile profileId);
    Optional<Relative> findByEmployeesId(Employees employeesId);
}