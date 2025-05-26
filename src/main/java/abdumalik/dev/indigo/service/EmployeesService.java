package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.EmployeesDto;
import abdumalik.dev.indigo.model.Employees;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.EmployeesRepo;
import abdumalik.dev.indigo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeesService {

    @Autowired
    EmployeesRepo repo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Employees> getAllEmployees() {
        return repo.findAll();
    }

    public Employees getEmployeeById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Employees> getByProfile(Profile profile) {
        return repo.findByProfileId(profile);
    }

    public Result create(EmployeesDto dto) {
        boolean b = repo.existsByProfileId(dto.getProfileId());
        if (b) {
            return new Result("Employees info created successfully", false);
        }

        Employees employee = new Employees();
        employee.setTitle(dto.getTitle());

        Optional<Profile> byId = profileRepo.findById(dto.getProfileId());
        Profile profile = byId.get();
        employee.setProfileId(profile);

        repo.save(employee);
        return new Result("Employees info created successfully", true);
    }

    public Result update(UUID id, EmployeesDto dto) {
        Optional<Employees> employee = repo.findById(id);
        if (employee.isPresent()) {
            Employees employee1 = employee.get();
            employee1.setTitle(dto.getTitle());

            Optional<Profile> byId = profileRepo.findById(dto.getProfileId());
            Profile profile = byId.get();
            employee1.setProfileId(profile);

            repo.save(employee1);
            return new Result("Employees info updated successfully", true);
        }
        return new Result("Employees info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Employees> employee = repo.findById(id);
        if (employee.isPresent()) {
            repo.delete(employee.get());
            return new Result("Employees info deleted successfully", true);
        }
        return new Result("Employees info not found", false);
    }

}