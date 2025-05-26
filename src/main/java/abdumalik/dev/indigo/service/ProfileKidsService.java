package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.ProfileKidsDto;
import abdumalik.dev.indigo.model.*;
import abdumalik.dev.indigo.repository.AddressRepo;
import abdumalik.dev.indigo.repository.GroupRepo;
import abdumalik.dev.indigo.repository.PhotoRepo;
import abdumalik.dev.indigo.repository.ProfileKidsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileKidsService {

    @Autowired
    ProfileKidsRepo repo;

    @Autowired
    PhotoRepo photoRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    AddressRepo addressRepo;

    public List<ProfileKids> getAllKids() {
        return repo.findAll();
    }

    public ProfileKids getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<ProfileKids> getByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Result create(ProfileKidsDto dto) {
        boolean b = repo.existsByUsername(dto.getUsername());
        if (b) {
            return new Result("This username is already exists", false);
        }

        ProfileKids profileKids = new ProfileKids();

        Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
        Photo photo = byId.get();
        profileKids.setPhotoId(photo);

        Optional<Group> byId1 = groupRepo.findById(dto.getGroupId());
        Group group = byId1.get();
        profileKids.setGroupId(group);

        profileKids.setFirstName(dto.getFirstName());
        profileKids.setLastName(dto.getLastName());
        profileKids.setUsername(dto.getUsername());
        profileKids.setBirthday(dto.getBirthday());

        Optional<Address> byId2 = addressRepo.findById(dto.getAddressId());
        Address address = byId2.get();
        profileKids.setAddressId(address);

        profileKids.setGender(dto.getGender());

        repo.save(profileKids);
        return new Result("Profile Kids created successfully", true);
    }

    public Result update(UUID id, ProfileKidsDto dto) {
        Optional<ProfileKids> profileKids = repo.findById(id);
        if (profileKids.isPresent()) {
            ProfileKids profileKids1 = profileKids.get();

            Optional<Photo> byId = photoRepo.findById(dto.getPhotoId());
            Photo photo = byId.get();
            profileKids1.setPhotoId(photo);

            Optional<Group> byId1 = groupRepo.findById(dto.getGroupId());
            Group group = byId1.get();
            profileKids1.setGroupId(group);

            profileKids1.setFirstName(dto.getFirstName());
            profileKids1.setLastName(dto.getLastName());
            profileKids1.setUsername(dto.getUsername());
            profileKids1.setBirthday(dto.getBirthday());

            Optional<Address> byId2 = addressRepo.findById(dto.getAddressId());
            Address address = byId2.get();
            profileKids1.setAddressId(address);

            profileKids1.setGender(dto.getGender());
            repo.save(profileKids1);
            return new Result("Profile Kids updated successfully", true);
        }
        return new Result("Profile Kids not found", false);
    }

    public Result delete(UUID id) {
        Optional<ProfileKids> profileKids = repo.findById(id);
        if (profileKids.isPresent()) {
            repo.delete(profileKids.get());
            return new Result("Profile Kids deleted successfully", true);
        }
        return new Result("Profile Kids not found", false);
    }

}