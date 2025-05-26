package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.AttendanceStatisticsDto;
import abdumalik.dev.indigo.model.AttendanceStatistics;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.AttendanceStatisticsRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttendanceStatisticsService {

    @Autowired
    AttendanceStatisticsRepo repo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<AttendanceStatistics> getAll() {
        return repo.findAll();
    }

    public AttendanceStatistics getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<AttendanceStatistics> getByProfile(Profile profile) {
        return repo.findByProfileId(profile);
    }

    public Optional<AttendanceStatistics> getByGroup(Group group) {
        return repo.findByGroup(group);
    }

    public Result create(AttendanceStatisticsDto dto) {
        AttendanceStatistics a = new AttendanceStatistics();
        a.setFromDate(dto.getFromDate());
        a.setToDate(dto.getToDate());

        Optional<Group> byId = groupRepo.findById(dto.getGroupId());
        Group group = byId.get();
        a.setGroup(group);

        Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
        Profile profile = byProfile.get();
        a.setProfileId(profile);

        repo.save(a);
        return new Result("Attendance statistics successfully created", true);
    }

    public Result update(UUID id, AttendanceStatisticsDto dto) {
        Optional<AttendanceStatistics> byId = repo.findById(id);
        if (byId.isPresent()) {
            AttendanceStatistics a = new AttendanceStatistics();
            a.setFromDate(dto.getFromDate());
            a.setToDate(dto.getToDate());

            Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
            Group group = byGroup.get();
            a.setGroup(group);

            Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
            Profile profile = byProfile.get();
            a.setProfileId(profile);

            repo.save(a);
            return new Result("Attendance statistics successfully updated", true);
        }
        return new Result("Attendance statistics not found", false);
    }

    public Result delete(UUID id) {
        Optional<AttendanceStatistics> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Attendance statistics successfully deleted", true);
        }
        return new Result("Attendance statistics not found", false);
    }

}