package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IconRepo extends JpaRepository<Icon, UUID> {
}