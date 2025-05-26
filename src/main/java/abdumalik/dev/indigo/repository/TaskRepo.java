package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
    Optional<Task> findByName(String name);

    boolean existsByProfileIdOrFiles(UUID profileId, UUID files);

}