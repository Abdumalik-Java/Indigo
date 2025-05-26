package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.FileDto;
import abdumalik.dev.indigo.model.File;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    FileRepo repo;

    public List<File> getAllFiles() {
        return repo.findAll();
    }

    public File getFileById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<File> getFileByName(String name) {
        return repo.findByFilename(name);
    }

    public Result create(FileDto dto) {
        File file = new File();
        file.setFilename(dto.getFileName());
        file.setContentType(dto.getContentType());
        file.setByteData(dto.getByteData());
        repo.save(file);
        return new Result("File saved successfully", true);
    }

    public Result update(UUID id, FileDto dto) {
        Optional<File> file = repo.findById(id);
        if (file.isPresent()) {
            File file1 = file.get();
            file1.setFilename(dto.getFileName());
            file1.setContentType(dto.getContentType());
            file1.setByteData(dto.getByteData());
            repo.save(file1);
            return new Result("File updated successfully", true);
        }
        return new Result("File not found", false);
    }

    public Result delete(UUID id) {
        Optional<File> file = repo.findById(id);
        if (file.isPresent()) {
            repo.delete(file.get());
            return new Result("File deleted successfully", true);
        }
        return new Result("File not found", false);
    }

}