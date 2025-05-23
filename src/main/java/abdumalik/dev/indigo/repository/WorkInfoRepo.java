package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkInfoRepo extends JpaRepository<WorkInfo, UUID> {
    Optional<WorkInfo> findByName(String name);
    Optional<WorkInfo> findByGroup(Group group);
}