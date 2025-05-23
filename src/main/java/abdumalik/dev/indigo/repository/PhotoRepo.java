package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhotoRepo extends JpaRepository<Photo, UUID> {
}