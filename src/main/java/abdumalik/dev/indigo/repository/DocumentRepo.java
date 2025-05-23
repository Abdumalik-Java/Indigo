package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepo extends JpaRepository<Document, UUID> {
    boolean existsBySeriaNumber(Integer seriaNumber);
}