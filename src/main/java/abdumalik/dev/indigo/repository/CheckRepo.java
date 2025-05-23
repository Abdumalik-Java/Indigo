package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Check;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CheckRepo extends JpaRepository<Check, UUID> {
    Optional<Check> findByGroup(Group group);
    Optional<Check> findByProfileId(Profile profileId);
    boolean existsByProfileId(Profile profileId);
}