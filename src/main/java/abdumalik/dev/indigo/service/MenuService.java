package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.MenuDto;
import abdumalik.dev.indigo.model.Category;
import abdumalik.dev.indigo.model.Menu;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.CategoryRepo;
import abdumalik.dev.indigo.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    MenuRepo repo;

    @Autowired
    CategoryRepo categoryRepo;

    public List<Menu> getAll() {
        return repo.findAll();
    }

    public Menu getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result save(MenuDto menuDto) {
        Menu menu = new Menu();
        menu.setName(menuDto.getName());

        Optional<Category> byId = categoryRepo.findById(menuDto.getCategoryId());
        Category category = byId.get();
        menu.setCategoryId((List<Category>) category);

        repo.save(menu);
        return new Result("Menu saved successfully", true);
    }

    public Result update(UUID id, MenuDto menuDto) {
        Optional<Menu> byId = repo.findById(id);
        if (byId.isPresent()) {
            Menu menu = byId.get();
            menu.setName(menuDto.getName());

            Optional<Category> byCategoryId = categoryRepo.findById(menuDto.getCategoryId());
            Category category = byCategoryId.get();
            menu.setCategoryId((List<Category>) category);

            repo.save(menu);
            return new Result("Menu updated successfully", true);
        }
        return new Result("Menu not found", false);
    }

    public Result delete(UUID id) {
        Optional<Menu> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Menu deleted successfully", true);
        }
        return new Result("Menu not found", false);
    }

}