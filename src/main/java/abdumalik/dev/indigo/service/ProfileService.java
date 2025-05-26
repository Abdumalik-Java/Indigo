package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.ProfileDto;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo repo;

    public List<Profile> getAllProfiles() {
        return repo.findAll();
    }

    public Profile getProfileById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Profile> getByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Result create(ProfileDto dto) {
        boolean b = repo.existsByUsername(dto.getUsername());
        if (b) {
            return new Result("Username is already exists", false);
        }

        Profile profile = new Profile();
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setUsername(dto.getUsername());
        profile.setAge(dto.getAge());
        profile.setBirthday(dto.getBirthday());
        profile.setGender(dto.getGender());
        repo.save(profile);
        return new Result("Profile successfully created", true);
    }

    public Result update(UUID id, ProfileDto dto) {
        Optional<Profile> profile = repo.findById(id);
        if (profile.isPresent()) {
            Profile profileToUpdate = profile.get();
            profileToUpdate.setFirstName(dto.getFirstName());
            profileToUpdate.setLastName(dto.getLastName());
            profileToUpdate.setUsername(dto.getUsername());
            profileToUpdate.setAge(dto.getAge());
            profileToUpdate.setBirthday(dto.getBirthday());
            profileToUpdate.setGender(dto.getGender());
            repo.save(profileToUpdate);
            return new Result("Profile successfully updated", true);
        }
        return new Result("Profile not found", false);
    }

    public Result delete(UUID id) {
        Optional<Profile> profile = repo.findById(id);
        if (profile.isPresent()) {
            repo.delete(profile.get());
            return new Result("Profile successfully deleted", true);
        }
        return new Result("Profile not found", false);
    }

}