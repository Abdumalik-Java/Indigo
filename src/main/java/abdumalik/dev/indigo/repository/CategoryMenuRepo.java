package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryMenuRepo extends JpaRepository<CategoryMenu, UUID> {
    Optional<CategoryMenu> findByName(String name);
}