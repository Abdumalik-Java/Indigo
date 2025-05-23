package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Calendar;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarRepo extends JpaRepository<Calendar, UUID> {
    Optional<Calendar> findByGroupName(Group groupName);
    Optional<Calendar> findByTaskId(List<Task> taskId);
}
