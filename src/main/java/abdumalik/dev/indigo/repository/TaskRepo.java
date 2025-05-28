package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface TaskRepo extends JpaRepository<Task, UUID> {
    Optional<Task> findByName(String name);
}