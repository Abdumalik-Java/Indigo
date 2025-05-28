package abdumalik.dev.indigo.controller;

import abdumalik.dev.indigo.dto.ProfileDto;
import abdumalik.dev.indigo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAllProfiles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getProfileById(id), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readByName(@PathVariable String username) {
        return new ResponseEntity<>(service.getByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> create(@RequestBody ProfileDto profileDto) {
        return new ResponseEntity<>(service.create(profileDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody ProfileDto profileDto) {
        return new ResponseEntity<>(service.update(id, profileDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}