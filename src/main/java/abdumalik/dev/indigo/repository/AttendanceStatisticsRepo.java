package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.AttendanceStatistics;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttendanceStatisticsRepo extends JpaRepository<AttendanceStatistics, UUID> {
    Optional<AttendanceStatistics> findByProfileId(Profile profileId);
    Optional<AttendanceStatistics> findByGroup(Group group);
}