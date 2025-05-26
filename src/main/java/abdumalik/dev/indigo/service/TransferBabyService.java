package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.TransferBabyDto;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.ProfileKids;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.TransferBaby;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.ProfileKidsRepo;
import abdumalik.dev.indigo.repository.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransferBabyService {

    @Autowired
    TransferRepo repo;

    @Autowired
    ProfileKidsRepo profileKidsRepo;

    @Autowired
    GroupRepo groupRepo;

    public List<TransferBaby> getAll() {
        return repo.findAll();
    }

    public TransferBaby getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<TransferBaby> getByProfileKids(ProfileKids profileKids) {
        return repo.findByProfileKidsId(profileKids);
    }

    public Optional<TransferBaby> getByGroupId(Group group) {
        return repo.findByGroup(group);
    }

    public Result create(TransferBabyDto dto) {
        TransferBaby transferBaby = new TransferBaby();

        Optional<ProfileKids> byProfileKids = profileKidsRepo.findById(dto.getProfileKidsId());
        ProfileKids profileKids = byProfileKids.get();
        transferBaby.setProfileKidsId(profileKids);

        transferBaby.setPeriod(dto.getPeriod());
        transferBaby.setTitle(dto.getTitle());

        Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
        Group group = byGroup.get();
        transferBaby.setGroup(group);

        repo.save(transferBaby);
        return new Result("Transfer baby info created successfully", true);
    }

    public Result update(UUID id, TransferBabyDto dto) {
        Optional<TransferBaby> byId = repo.findById(id);
        if (byId.isPresent()) {
            TransferBaby transferBaby = byId.get();

            Optional<ProfileKids> byProfileKids = profileKidsRepo.findById(dto.getProfileKidsId());
            ProfileKids profileKids = byProfileKids.get();
            transferBaby.setProfileKidsId(profileKids);

            transferBaby.setPeriod(dto.getPeriod());
            transferBaby.setTitle(dto.getTitle());

            Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
            Group group = byGroup.get();
            transferBaby.setGroup(group);

            repo.save(transferBaby);
            return new Result("Transfer baby info updated successfully", true);
        }
        return new Result("Transfer baby info not found", false);
    }

    public Result delete(UUID id) {
        Optional<TransferBaby> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Transfer baby info deleted successfully", true);
        }
        return new Result("Transfer baby info not found", false);
    }

}