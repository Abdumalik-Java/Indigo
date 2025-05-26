package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.RelativeDto;
import abdumalik.dev.indigo.model.Employees;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Relative;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.EmployeesRepo;
import abdumalik.dev.indigo.repository.ProfileRepo;
import abdumalik.dev.indigo.repository.RelativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RelativeService {

    @Autowired
    RelativeRepo repo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    EmployeesRepo employeesRepo;

    public List<Relative> findAll() {
        return repo.findAll();
    }

    public Relative findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Relative> findByProfile(Profile profile) {
        return repo.findByProfileId(profile);
    }

    public Optional<Relative> findByEmployees(Employees employees) {
        return repo.findByEmployeesId(employees);
    }

    public Result create(RelativeDto dto) {
        Relative rel = new Relative();

        Optional<Profile> byId = profileRepo.findById(dto.getProfileId());
        Profile profile = byId.get();
        rel.setProfileId(profile);

        Optional<Employees> byEmployee = employeesRepo.findById(dto.getEmployeesId());
        Employees employee = byEmployee.get();
        rel.setEmployeesId(employee);

        repo.save(rel);
        return new Result("Relative info created successfully", true);
    }

    public Result update(UUID id, RelativeDto dto) {
        Optional<Relative> byId = repo.findById(id);
        if (byId.isPresent()) {
            Relative rel = byId.get();

            Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
            Profile profile = byProfile.get();
            rel.setProfileId(profile);

            Optional<Employees> byEmployee = employeesRepo.findById(dto.getEmployeesId());
            Employees employee = byEmployee.get();
            rel.setEmployeesId(employee);

            repo.save(rel);
            return new Result("Relative info updated successfully", true);
        }
        return new Result("Relative info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Relative> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Relative info deleted successfully", true);
        }
        return new Result("Relative info not found", false);
    }

}