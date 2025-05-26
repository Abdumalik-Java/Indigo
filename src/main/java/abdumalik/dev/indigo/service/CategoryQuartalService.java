package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.CategoryQuartalDto;
import abdumalik.dev.indigo.model.CategoryQuartal;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.CategoryQuartalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryQuartalService {

    @Autowired
    CategoryQuartalRepo repo;

    public List<CategoryQuartal> getAll() {
        return repo.findAll();
    }

    public CategoryQuartal getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<CategoryQuartal> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(CategoryQuartalDto dto) {
        CategoryQuartal quartal = new CategoryQuartal();
        quartal.setName(dto.getName());
        quartal.setDescription(dto.getDescription());
        quartal.setStatus(dto.getStatus());
        quartal.setNumber(dto.getNumber());
        repo.save(quartal);
        return new Result("CategoryQuartal info created successfully", true);
    }

    public Result update(UUID id, CategoryQuartalDto dto) {
        Optional<CategoryQuartal> byId = repo.findById(id);
        if (byId.isPresent()) {
            CategoryQuartal quartal = byId.get();
            quartal.setName(dto.getName());
            quartal.setDescription(dto.getDescription());
            quartal.setStatus(dto.getStatus());
            quartal.setNumber(dto.getNumber());
            repo.save(quartal);
            return new Result("CategoryQuartal info updated successfully", true);
        }
        return new Result("CategoryQuartal info not found", false);
    }

    public Result delete(UUID id) {
        Optional<CategoryQuartal> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("CategoryQuartal info deleted successfully", true);
        }
        return new Result("CategoryQuartal info not found", false);
    }

}