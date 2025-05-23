package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Action;
import abdumalik.dev.indigo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ActionRepo extends JpaRepository<Action, UUID> {
    Optional<Action> findByGroup(Group group);
}