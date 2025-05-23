package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Category;
import abdumalik.dev.indigo.model.Form;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormRepo extends JpaRepository<Form, UUID> {
    Optional<Form> findByCategoryId(List<Category> categoryId);
    Optional<Form> findByTemplateId(List<Template> templateId);
    Optional<Form> findByGroupId(Group groupId);
}
