package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.CategoryMenuDto;
import abdumalik.dev.indigo.model.CategoryMenu;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.CategoryMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryMenuService {

    @Autowired
    CategoryMenuRepo repo;

    public List<CategoryMenu> getAll() {
        return repo.findAll();
    }

    public CategoryMenu getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<CategoryMenu> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(CategoryMenuDto dto) {
        CategoryMenu categoryMenu = new CategoryMenu();
        categoryMenu.setName(dto.getName());
        categoryMenu.setKcal(dto.getKcal());
        categoryMenu.setDescription(dto.getDescription());
        repo.save(categoryMenu);
        return new Result("CategoryMenu successfully created", true);
    }

    public Result update(UUID id, CategoryMenuDto dto) {
        Optional<CategoryMenu> byId = repo.findById(id);
        if (byId.isPresent()) {
            CategoryMenu categoryMenu = byId.get();
            categoryMenu.setName(dto.getName());
            categoryMenu.setKcal(dto.getKcal());
            categoryMenu.setDescription(dto.getDescription());
            repo.save(categoryMenu);
            return new Result("CategoryMenu successfully updated", true);
        }
        return new Result("CategoryMenu not found", false);
    }

    public Result delete(UUID id) {
        Optional<CategoryMenu> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("CategoryMenu successfully deleted", true);
        }
        return new Result("CategoryMenu not found", false);
    }

}