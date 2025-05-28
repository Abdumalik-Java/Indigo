package abdumalik.dev.indigo.controller;

import abdumalik.dev.indigo.dto.CategoryQuartalDto;
import abdumalik.dev.indigo.service.CategoryQuartalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categoryQuartal")
public class CategoryQuartalController {

    @Autowired
    CategoryQuartalService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody CategoryQuartalDto categoryQuartalDto) {
        return new ResponseEntity<>(service.create(categoryQuartalDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CategoryQuartalDto categoryQuartalDto) {
        return new ResponseEntity<>(service.update(id, categoryQuartalDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}