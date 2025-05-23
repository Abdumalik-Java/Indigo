package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.ProfileKids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileKidsRepo extends JpaRepository<ProfileKids, UUID> {
    Optional<ProfileKids> findByUsername(String username);
    boolean existsByUsername(String username);
}