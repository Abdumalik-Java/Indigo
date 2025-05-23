package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.CategoryQuartal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryQuartalRepo extends JpaRepository<CategoryQuartal, UUID> {
    Optional<CategoryQuartal> findByName(String name);
}