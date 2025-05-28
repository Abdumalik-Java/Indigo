package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.ReportDto;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Report;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.ProfileRepo;
import abdumalik.dev.indigo.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    ReportRepo repo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Report> getAllReport() {
        return repo.findAll();
    }

    public Report getReportById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Report> getByProfile(Profile profile) {
        return repo.findByProfileId(profile);
    }

    public Result create(ReportDto dto) {
        Report report = new Report();
        report.setTitle(dto.getTitle());

        Optional<Profile> byId = profileRepo.findById(dto.getProfileId());
        Profile profile = byId.get();
        report.setProfileId(profile);

        report.setCount(dto.getCount());
        report.setDescription(dto.getDescription());

        repo.save(report);
        return new Result("Successfully created report", true);
    }

    public Result update(UUID id, ReportDto dto) {
        Optional<Report> byId = repo.findById(id);
        if (byId.isPresent()) {
            Report report = byId.get();
            report.setTitle(dto.getTitle());

            Optional<Profile> byProfile = profileRepo.findById(dto.getProfileId());
            Profile profile = byProfile.get();
            report.setProfileId(profile);

            report.setCount(dto.getCount());
            report.setDescription(dto.getDescription());

            repo.save(report);
            return new Result("Successfully updated report", true);
        }
        return new Result("Not found 404", false);
    }

    public Result delete(UUID id) {
        Optional<Report> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Successfully deleted report", true);
        }
        return new Result("Not found 404", false);
    }

}