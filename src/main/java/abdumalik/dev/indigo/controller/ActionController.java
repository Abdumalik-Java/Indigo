package abdumalik.dev.indigo.controller;

import abdumalik.dev.indigo.dto.ActionDto;
import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    ActionService service;

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

    @GetMapping("/{group}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN', 'TEACHER', 'SUPERVISOR', 'DEPUTY_HEAD', 'PARENT', 'CHILDREN')")
    public HttpEntity<?> readByGroup(@RequestBody Group group) {
        return new ResponseEntity<>(service.getByGroup(group), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody ActionDto actionDto) {
        return new ResponseEntity<>(service.create(actionDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody ActionDto actionDto) {
        return new ResponseEntity<>(service.update(id, actionDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}