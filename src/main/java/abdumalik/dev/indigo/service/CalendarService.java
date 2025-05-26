package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.CalendarDto;
import abdumalik.dev.indigo.model.Calendar;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.Task;
import abdumalik.dev.indigo.repository.CalendarRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CalendarService {

    @Autowired
    CalendarRepo repo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    TaskRepo taskRepo;

    public List<Calendar> getAll() {
        return repo.findAll();
    }

    public Calendar getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Calendar> getByGroupId(Group group) {
        return repo.findByGroupName(group);
    }

    public Optional<Calendar> getByTaskId(Task task) {
        return repo.findByTaskId((List<Task>) task);
    }

    public Result create(CalendarDto dto) {
        Calendar calendar = new Calendar();

        Optional<Group> byId = groupRepo.findById(dto.getGroupId());
        Group group = byId.get();
        calendar.setGroupName(group);

        Optional<Task> byTaskId = taskRepo.findById(dto.getTaskId());
        Task task = byTaskId.get();
        calendar.setTaskId((List<Task>) task);

        calendar.setStatus(dto.getStatus());
        repo.save(calendar);
        return new Result("Calendar info successfully created", true);
    }

    public Result update(UUID id, CalendarDto dto) {
        Optional<Calendar> byId = repo.findById(id);
        if (byId.isPresent()) {
            Calendar calendar = byId.get();

            Optional<Group> byGroupId = groupRepo.findById(dto.getGroupId());
            Group group = byGroupId.get();
            calendar.setGroupName(group);

            Optional<Task> byTaskId = taskRepo.findById(dto.getTaskId());
            Task task = byTaskId.get();
            calendar.setTaskId((List<Task>) task);

            calendar.setStatus(dto.getStatus());
            repo.save(calendar);
            return new Result("Calendar info successfully updated", true);
        }
        return new Result("Calendar not found", false);
    }

    public Result delete(UUID id) {
        Optional<Calendar> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Calendar info successfully deleted", true);
        }
        return new Result("Calendar not found", false);
    }

}