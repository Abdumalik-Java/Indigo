package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.PhotoDto;
import abdumalik.dev.indigo.model.Photo;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    PhotoRepo repo;

    public List<Photo> getAll() {
        return repo.findAll();
    }

    public Photo getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(PhotoDto dto) {
        Photo photo = new Photo();
        photo.setName(dto.getName());
        photo.setSize(dto.getSize());
        photo.setPath(dto.getPath());
        photo.setType(dto.getType());
        photo.setByteData(dto.getByteData());
        repo.save(photo);
        return new Result("Photo info created successfully", true);
    }

    public Result update(UUID id, PhotoDto dto) {
        Optional<Photo> photo = repo.findById(id);
        if (photo.isPresent()) {
            Photo p = photo.get();
            p.setName(dto.getName());
            p.setSize(dto.getSize());
            p.setPath(dto.getPath());
            p.setType(dto.getType());
            p.setByteData(dto.getByteData());
            repo.save(p);
            return new Result("Photo info updated successfully", true);
        }
        return new Result("Photo info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Photo> photo = repo.findById(id);
        if (photo.isPresent()) {
            repo.deleteById(id);
            return new Result("Photo info deleted successfully", true);
        }
        return new Result("Photo info not found", false);
    }

}