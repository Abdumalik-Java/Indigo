package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.GroupDto;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

    @Autowired
    GroupRepo repo;

    public List<Group> getAllGroups() {
        return repo.findAll();
    }

    public Group getGroupById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Group> getGroupByName(String name) {
        return repo.findByName(name);
    }

    public Result create(GroupDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        group.setGroupNumber(dto.getGroupNumber());
        group.setGroupYear(dto.getGroupYear());
        repo.save(group);
        return new Result("Group info created successfully", true);
    }

    public Result update(UUID id, GroupDto dto) {
        Optional<Group> group = repo.findById(id);
        if (group.isPresent()) {
            Group g = group.get();
            g.setName(dto.getName());
            g.setGroupNumber(dto.getGroupNumber());
            g.setGroupYear(dto.getGroupYear());
            repo.save(g);
            return new Result("Group info updated successfully", true);
        }
        return new Result("Group info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Group> group = repo.findById(id);
        if (group.isPresent()) {
            repo.delete(group.get());
            return new Result("Group info deleted successfully", true);
        }
        return new Result("Group info not found", false);
    }

}