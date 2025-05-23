package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FileRepo extends JpaRepository<File, UUID> {
    Optional<File> findByFilename(String filename);
}