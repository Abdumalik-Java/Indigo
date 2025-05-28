package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReportRepo extends JpaRepository<Report, UUID> {
    Optional<Report> findByProfileId(Profile profileId);
}