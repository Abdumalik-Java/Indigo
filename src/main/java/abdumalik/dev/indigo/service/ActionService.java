package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.ActionDto;
import abdumalik.dev.indigo.model.Action;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.ActionRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActionService {

    @Autowired
    ActionRepo repo;

    @Autowired
    GroupRepo groupRepo;

    public List<Action> getAll() {
        return repo.findAll();
    }

    public Action getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Action> getByGroup(Group group) {
        return repo.findByGroup(group);
    }

    public Result create(ActionDto dto) {
        Action action = new Action();
        action.setDate(dto.getDate());

        Optional<Group> byId = groupRepo.findById(dto.getGroupId());
        Group group = byId.get();
        action.setGroup(group);

        action.setEndDate(dto.getEndDate());
        action.setTransferReason(dto.getTransferReason());
        repo.save(action);
        return new Result("Action successfully created", true);
    }

    public Result update(UUID id, ActionDto dto) {
        Optional<Action> action = repo.findById(id);
        if (action.isPresent()) {
            Action action1 = action.get();
            action1.setDate(dto.getDate());

            Optional<Group> byId = groupRepo.findById(dto.getGroupId());
            Group group = byId.get();
            action1.setGroup(group);

            action1.setEndDate(dto.getEndDate());
            action1.setTransferReason(dto.getTransferReason());
            repo.save(action1);
            return new Result("Action successfully updated", true);
        }
        return new Result("Action not found", false);
    }

    public Result delete(UUID id) {
        Optional<Action> action = repo.findById(id);
        if (action.isPresent()) {
            repo.delete(action.get());
            return new Result("Action successfully deleted", true);
        }
        return new Result("Action not found", false);
    }

}