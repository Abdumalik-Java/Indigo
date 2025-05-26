package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.StatisticsDto;
import abdumalik.dev.indigo.model.CategoryQuartal;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.Statistics;
import abdumalik.dev.indigo.repository.CategoryQuartalRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.StatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatisticsService {

    @Autowired
    StatisticsRepo repo;

    @Autowired
    CategoryQuartalRepo categoryQuartalRepo;

    @Autowired
    GroupRepo groupRepo;

    public List<Statistics> getAll() {
        return repo.findAll();
    }

    public Statistics getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Statistics> getByCategoryQuartal(CategoryQuartal categoryQuartal) {
        return repo.findByCategoryQuartal(categoryQuartal);
    }

    public Optional<Statistics> getByGroup(Group group) {
        return repo.findByGroup(group);
    }

    public Result create(StatisticsDto dto) {
        Statistics statistics = new Statistics();

        Optional<CategoryQuartal> byId = categoryQuartalRepo.findById(dto.getCategoryQuartalId());
        CategoryQuartal categoryQuartal = byId.get();
        statistics.setCategoryQuartal(categoryQuartal);

        statistics.setFromDate(dto.getFromDate());
        statistics.setToDate(dto.getToDate());

        Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
        Group group = byGroup.get();
        statistics.setGroup(group);

        repo.save(statistics);
        return new Result("Successfully created statistics", true);
    }

    public Result update(UUID id, StatisticsDto dto) {
        Optional<Statistics> byId = repo.findById(id);
        if (byId.isPresent()) {
            Statistics statistics = byId.get();

            Optional<CategoryQuartal> byCategoryQuartal = categoryQuartalRepo.findById(dto.getCategoryQuartalId());
            CategoryQuartal categoryQuartal = byCategoryQuartal.get();
            statistics.setCategoryQuartal(categoryQuartal);

            statistics.setFromDate(dto.getFromDate());
            statistics.setToDate(dto.getToDate());

            Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
            Group group = byGroup.get();
            statistics.setGroup(group);

            repo.save(statistics);
            return new Result("Successfully updated statistics", true);
        }
        return new Result("Not found 404", false);
    }

    public Result delete(UUID id) {
        Optional<Statistics> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Successfully deleted statistics", true);
        }
        return new Result("Not found 404", false);
    }

}