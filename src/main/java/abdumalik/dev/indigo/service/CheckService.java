package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.CheckDto;
import abdumalik.dev.indigo.model.Check;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.CheckRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckService {

    @Autowired
    CheckRepo repo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Check> findAll() {
        return repo.findAll();
    }

    public Check findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Check> findByGroup(Group group) {
        return repo.findByGroup(group);
    }

    public Optional<Check> findByProfile(Profile profile) {
        return repo.findByProfileId(profile);
    }

    public Result create(CheckDto dto) {
        Check check = new Check();
        check.setFromDate(dto.getFromDate());
        check.setToDate(dto.getToDate());
        check.setCheckType(dto.getCheckType());

        Optional<Group> byId = groupRepo.findById(dto.getGroupId());
        Group group = byId.get();
        check.setGroup(group);

        check.setPaid(dto.isPaid());
        check.setUnpaid(dto.isUnpaid());
        check.setSumma(dto.getSumma());

        Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
        Profile profile = byProfile.get();
        check.setProfileId(profile);

        repo.save(check);
        return new Result("Check info created successfully", true);
    }

    public Result update(UUID id, CheckDto dto) {
        Optional<Check> check = repo.findById(id);
        if (check.isPresent()) {
            Check check1 = check.get();
            check1.setFromDate(dto.getFromDate());
            check1.setToDate(dto.getToDate());
            check1.setCheckType(dto.getCheckType());

            Optional<Group> byId = groupRepo.findById(dto.getGroupId());
            Group group = byId.get();
            check1.setGroup(group);

            check1.setPaid(dto.isPaid());
            check1.setUnpaid(dto.isUnpaid());
            check1.setSumma(dto.getSumma());

            Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
            Profile profile = byProfile.get();
            check1.setProfileId(profile);

            repo.save(check1);
            return new Result("Check info updated successfully", true);
        }
        return new Result("Check info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Check> check = repo.findById(id);
        if (check.isPresent()) {
            repo.delete(check.get());
            return new Result("Check info deleted successfully", true);
        }
        return new Result("Check info not found", false);
    }

}