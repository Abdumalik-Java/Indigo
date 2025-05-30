package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepo extends JpaRepository<Category, UUID> {
    Optional<Category> findByName(String name);
}