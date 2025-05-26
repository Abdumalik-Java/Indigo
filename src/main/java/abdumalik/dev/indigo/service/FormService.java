package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.FormDto;
import abdumalik.dev.indigo.model.*;
import abdumalik.dev.indigo.repository.CategoryRepo;
import abdumalik.dev.indigo.repository.FormRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.TemplateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FormService {

    @Autowired
    FormRepo repo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    TemplateRepo templateRepo;

    @Autowired
    GroupRepo groupRepo;

    public List<Form> getAll() {
        return repo.findAll();
    }

    public Form getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Form> getByCategory(Category category) {
        return repo.findByCategoryId((List<Category>) category);
    }

    public Optional<Form> getByTemplate(Template template) {
        return repo.findByTemplateId((List<Template>) template);
    }

    public Optional<Form> getByGroup(Group group) {
        return repo.findByGroupId(group);
    }

    public Result create(FormDto dto) {
        Form form = new Form();

        Optional<Category> byId = categoryRepo.findById(dto.getCategoryId());
        Category category = byId.get();
        form.setCategoryId((List<Category>) category);

        form.setPriority(dto.getPriority());

        Optional<Template> byTemplate = templateRepo.findById(dto.getTemplateId());
        Template template = byTemplate.get();
        form.setTemplateId((List<Template>) template);

        Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
        Group group = byGroup.get();
        form.setGroupId(group);

        form.setFromDate(dto.getFromDate());
        form.setToDate(dto.getToDate());
        form.setTitle(dto.getTitle());
        form.setDescription(dto.getDescription());

        repo.save(form);
        return new Result("Form info created successfully", true);
    }

    public Result update(UUID id, FormDto dto) {
        Optional<Form> byId = repo.findById(id);
        if (byId.isPresent()) {
            Form form = byId.get();

            Optional<Category> byCategory = categoryRepo.findById(dto.getCategoryId());
            Category category = byCategory.get();
            form.setCategoryId((List<Category>) category);
            form.setPriority(dto.getPriority());

            Optional<Template> byTemplate = templateRepo.findById(dto.getTemplateId());
            Template template = byTemplate.get();
            form.setTemplateId((List<Template>) template);

            Optional<Group> byGroup = groupRepo.findById(dto.getGroupId());
            Group group = byGroup.get();
            form.setGroupId(group);

            form.setFromDate(dto.getFromDate());
            form.setToDate(dto.getToDate());
            form.setTitle(dto.getTitle());
            form.setDescription(dto.getDescription());

            repo.save(form);
            return new Result("Form info updated successfully", true);
        }
        return new Result("Form info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Form> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Form info deleted successfully", true);
        }
        return new Result("Form info not found", false);
    }

}