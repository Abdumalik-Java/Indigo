package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MenuRepo extends JpaRepository<Menu, UUID> {
    Optional<Menu> findByName(String name);
    boolean existsByName(String name);
}