package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.WorkInfoDto;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.WorkInfo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.WorkInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkInfoService {

    @Autowired
    WorkInfoRepo repo;

    @Autowired
    GroupRepo groupRepo;

    public List<WorkInfo> findAll() {
        return repo.findAll();
    }

    public WorkInfo findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<WorkInfo> findByName(String name) {
        return repo.findByName(name);
    }

    public Result create(WorkInfoDto dto) {
        WorkInfo workInfo = new WorkInfo();
        workInfo.setName(dto.getName());
        workInfo.setPosition(dto.getPosition());
        workInfo.setPhoneNumber(dto.getPhoneNumber());

        Optional<Group> group = groupRepo.findById(dto.getGroupId());
        Group group1 = group.get();
        workInfo.setGroup(group1);

        repo.save(workInfo);
        return new Result("Work info created successfully", true);
    }

    public Result update(UUID id, WorkInfoDto dto) {
        Optional<WorkInfo> workInfo = repo.findById(id);
        if (workInfo.isPresent()) {
            WorkInfo workInfo1 = workInfo.get();
            workInfo1.setName(dto.getName());
            workInfo1.setPosition(dto.getPosition());
            workInfo1.setPhoneNumber(dto.getPhoneNumber());

            Optional<Group> group = groupRepo.findById(dto.getGroupId());
            Group group1 = group.get();
            workInfo1.setGroup(group1);

            repo.save(workInfo1);
            return new Result("Work info updated successfully", true);
        }
        return new Result("Work info not found", false);
    }

    public Result delete(UUID id) {
        Optional<WorkInfo> workInfo = repo.findById(id);
        if (workInfo.isPresent()) {
            repo.delete(workInfo.get());
            return new Result("Work info deleted successfully", true);
        }
        return new Result("Work info not found", false);
    }

}