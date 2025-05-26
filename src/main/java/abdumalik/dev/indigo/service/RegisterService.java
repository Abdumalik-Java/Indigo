package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.RegisterDto;
import abdumalik.dev.indigo.model.Register;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterService {

    @Autowired
    RegisterRepo repo;

    public List<Register> getAll() {
        return repo.findAll();
    }

    public Register getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(RegisterDto dto) {
        boolean b = repo.existsByPhoneNumber(dto.getPhoneNumber());
        if (b) {
            return new Result("This phone number is already exists", false);
        }

        Register register = new Register();
        register.setPhoneNumber(dto.getPhoneNumber());
        register.setPassword(dto.getPassword());
        register.setRePassword(dto.getRePassword());

        repo.save(register);
        return new Result("Register successfully created", true);
    }

    public Result update(UUID id, RegisterDto dto) {
        Optional<Register> byId = repo.findById(id);
        if (byId.isPresent()) {
            Register register = byId.get();
            register.setPhoneNumber(dto.getPhoneNumber());
            register.setPassword(dto.getPassword());
            register.setRePassword(dto.getRePassword());
            repo.save(register);
            return new Result("Register successfully updated", true);
        }
        return new Result("Register not found", false);
    }

    public Result delete(UUID id) {
        Optional<Register> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Register successfully deleted", true);
        }
        return new Result("Register not found", false);
    }

}