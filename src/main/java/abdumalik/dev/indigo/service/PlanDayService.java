package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.PlanDayDto;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.PlanDay;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.PlanDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanDayService {

    @Autowired
    PlanDayRepo repo;

    @Autowired
    GroupRepo groupRepo;

    public List<PlanDay> getAllPlanDays() {
        return repo.findAll();
    }

    public PlanDay getPlanDayById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(PlanDayDto dto) {
        PlanDay planDay = new PlanDay();
        planDay.setFromDate(dto.getFromDate());
        planDay.setPeriod(dto.getPeriod());

        Optional<Group> group = groupRepo.findById(dto.getGroupId());
        Group group1 = group.get();
        planDay.setGroup(group1);

        repo.save(planDay);
        return new Result("PlanDay successfully created", true);
    }

    public Result update(UUID id, PlanDayDto dto) {
        Optional<PlanDay> planDay = repo.findById(id);
        if (planDay.isPresent()) {
            PlanDay planDay1 = planDay.get();
            planDay1.setFromDate(dto.getFromDate());
            planDay1.setPeriod(dto.getPeriod());

            Optional<Group> group = groupRepo.findById(dto.getGroupId());
            Group group1 = group.get();
            planDay1.setGroup(group1);

            repo.save(planDay1);
            return new Result("PlanDay successfully updated", true);
        }
        return new Result("PlanDay not found", false);
    }

    public Result delete(UUID id) {
        Optional<PlanDay> planDay = repo.findById(id);
        if (planDay.isPresent()) {
            repo.delete(planDay.get());
            return new Result("PlanDay successfully deleted", true);
        }
        return new Result("PlanDay not found", false);
    }

}