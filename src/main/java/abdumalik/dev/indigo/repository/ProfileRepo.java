package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepo extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByUsername(String username);
    boolean existsByUsername(String username);
}