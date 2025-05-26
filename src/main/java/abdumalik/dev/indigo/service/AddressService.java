package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.AddressDto;
import abdumalik.dev.indigo.model.Address;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    AddressRepo repo;

    public List<Address> getAll() {
        return repo.findAll();
    }

    public Address getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AddressDto dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setRegion(dto.getRegion());
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        repo.save(address);
        return new Result("Address infos successfully created", true);
    }

    public Result update(UUID id, AddressDto dto) {
        Optional<Address> address = repo.findById(id);
        if (address.isPresent()) {
            Address address1 = address.get();
            address1.setCity(dto.getCity());
            address1.setRegion(dto.getRegion());
            address1.setStreet(dto.getStreet());
            address1.setHomeNumber(dto.getHomeNumber());
            repo.save(address1);
            return new Result("Address infos successfully updated", true);
        }
        return new Result("Address not found", false);
    }

    public Result delete(UUID id) {
        Optional<Address> address = repo.findById(id);
        if (address.isPresent()) {
            repo.delete(address.get());
            return new Result("Address infos successfully deleted", true);
        }
        return new Result("Address not found", false);
    }

}