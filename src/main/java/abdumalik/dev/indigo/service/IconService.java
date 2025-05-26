package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.IconDto;
import abdumalik.dev.indigo.model.Icon;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IconService {

    @Autowired
    IconRepo repo;

    public List<Icon> getAllIcons() {
        return repo.findAll();
    }

    public Icon getIconById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(IconDto dto) {
        Icon icon = new Icon();
        icon.setTitle(dto.getTitle());
        icon.setIconId(dto.getIconId());
        icon.setOrderIndex(dto.getOrderIndex());
        icon.setActive(dto.isActive());
        repo.save(icon);
        return new Result("Icon saved successfully", true);
    }

    public Result update(UUID id, IconDto dto) {
        Optional<Icon> icon = repo.findById(id);
        if (icon.isPresent()) {
            Icon i = icon.get();
            i.setTitle(dto.getTitle());
            i.setIconId(dto.getIconId());
            i.setOrderIndex(dto.getOrderIndex());
            i.setActive(dto.isActive());
            repo.save(i);
            return new Result("Icon updated successfully", true);
        }
        return new Result("Icon not found", false);
    }

    public Result delete(UUID id) {
        Optional<Icon> icon = repo.findById(id);
        if (icon.isPresent()) {
            repo.delete(icon.get());
            return new Result("Icon deleted successfully", true);
        }
        return new Result("Icon not found", false);
    }

}