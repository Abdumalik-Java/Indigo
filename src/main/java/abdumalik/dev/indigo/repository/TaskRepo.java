package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.File;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {
    Optional<Task> findByName(String name);

    boolean existsByProfileId(Profile profileId);

    boolean existsByFiles(List<File> files);

}