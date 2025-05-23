package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TemplateRepo extends JpaRepository<Template, UUID> {
    Optional<Template> findByName(String name);
    boolean existsByName(String name);
}