package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.CategoryQuartal;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StatisticsRepo extends JpaRepository<Statistics, UUID> {
    Optional<Statistics> findByCategoryQuartal(CategoryQuartal categoryQuartal);
    Optional<Statistics> findByGroup(Group group);
}