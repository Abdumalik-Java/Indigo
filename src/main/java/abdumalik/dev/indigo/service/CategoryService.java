package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.CategoryDto;
import abdumalik.dev.indigo.model.Category;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo repo;

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Category> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setStatus(dto.getStatus());
        repo.save(category);
        return new Result("Category info created successfully", true);
    }

    public Result update(UUID id, CategoryDto dto) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(dto.getName());
            category.setDescription(dto.getDescription());
            category.setStatus(dto.getStatus());
            repo.save(category);
            return new Result("Category info updated successfully", true);
        }
        return new Result("Category info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Category> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Category info deleted successfully", true);
        }
        return new Result("Category info not found", false);
    }

}