package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.TemplateDto;
import abdumalik.dev.indigo.model.Icon;
import abdumalik.dev.indigo.model.Photo;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.model.Template;
import abdumalik.dev.indigo.repository.IconRepo;
import abdumalik.dev.indigo.repository.PhotoRepo;
import abdumalik.dev.indigo.repository.TemplateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemplateService {

    @Autowired
    TemplateRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    IconRepo iconRepo;

    public List<Template> getAll() {
        return repo.findAll();
    }

    public Template getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Template> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(TemplateDto dto) {
        Template template = new Template();
        template.setName(dto.getName());
        template.setDescription(dto.getDescription());
        template.setStatus(dto.getStatus());

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        template.setPhotoId((List<Photo>) photo);

        Optional<Icon> byIcon = iconRepo.findById(dto.getIconId());
        Icon icon = byIcon.get();
        template.setIconId((List<Icon>) icon);

        repo.save(template);
        return new Result("Template info created successfully", true);
    }

    public Result update(UUID id, TemplateDto dto) {
        Optional<Template> template = repo.findById(id);
        if (template.isPresent()) {
            Template template1 = template.get();
            template1.setName(dto.getName());
            template1.setDescription(dto.getDescription());
            template1.setStatus(dto.getStatus());

            Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId.get();
            template1.setPhotoId((List<Photo>) photo);

            Optional<Icon> byIcon = iconRepo.findById(dto.getIconId());
            Icon icon = byIcon.get();
            template1.setIconId((List<Icon>) icon);

            repo.save(template1);
            return new Result("Template info updated successfully", true);
        }
        return new Result("Template info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Template> template = repo.findById(id);
        if (template.isPresent()) {
            repo.delete(template.get());
            return new Result("Template info deleted successfully", true);
        }
        return new Result("Template info not found", false);
    }

}