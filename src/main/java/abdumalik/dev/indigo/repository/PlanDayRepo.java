package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.PlanDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlanDayRepo extends JpaRepository<PlanDay, UUID> {
    Optional<PlanDay> findByGroup(Group group);
}