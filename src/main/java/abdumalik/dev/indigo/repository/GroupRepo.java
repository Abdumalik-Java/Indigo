package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepo extends JpaRepository<Group, UUID> {
    Optional<Group> findByName(String name);
    boolean existsByName(String name);
}