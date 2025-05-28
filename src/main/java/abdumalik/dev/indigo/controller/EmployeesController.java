package abdumalik.dev.indigo.controller;

import abdumalik.dev.indigo.dto.EmployeesDto;
import abdumalik.dev.indigo.model.Profile;
import abdumalik.dev.indigo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    EmployeesService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/{profile}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> readProfile(@PathVariable Profile profile) {
        return new ResponseEntity<>(service.getByProfile(profile), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> create(@RequestBody EmployeesDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody EmployeesDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}