package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.TaskDto;
import abdumalik.dev.indigo.model.File;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.Task;
import abdumalik.dev.indigo.repository.FileRepo;
import abdumalik.dev.indigo.repository.ProfileRepo;
import abdumalik.dev.indigo.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepo repo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    FileRepo fileRepo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Task> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(TaskDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setFromDate(dto.getFromDate());
        task.setToDate(dto.getToDate());

        Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
        Profile profile = byProfile.get();
        task.setProfileId(profile);

        Optional<File> byFile = fileRepo.findById(dto.getFileId());
        File file = byFile.get();
        task.setFiles((List<File>) file);

        repo.save(task);
        return new Result("Task successfully created", true);
    }

    public Result update(UUID id, TaskDto dto) {
        Optional<Task> task = repo.findById(id);
        if (task.isPresent()) {
            Task t = task.get();
            t.setName(dto.getName());
            t.setDescription(dto.getDescription());
            t.setPriority(dto.getPriority());
            t.setFromDate(dto.getFromDate());
            t.setToDate(dto.getToDate());

            Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
            Profile profile = byProfile.get();
            t.setProfileId(profile);

            Optional<File> byFile = fileRepo.findById(dto.getFileId());
            File file = byFile.get();
            t.setFiles((List<File>) file);

            repo.save(t);
            return new Result("Task successfully updated", true);
        }
        return new Result("Task not found", false);
    }

    public Result delete(UUID id) {
        Optional<Task> task = repo.findById(id);
        if (task.isPresent()) {
            repo.delete(task.get());
            return new Result("Task successfully deleted", true);
        }
        return new Result("Task not found", false);
    }

}