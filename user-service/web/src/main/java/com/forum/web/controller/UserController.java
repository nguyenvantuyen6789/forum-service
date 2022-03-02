package com.forum.web.controller;

import com.forum.UserRepository;
import com.forum.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public List<UserEntity> get() {
        List<UserEntity> entities = userRepo.findAll();

        return entities;
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity entityRequest) {
        userRepo.save(entityRequest);

        return entityRequest;
    }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable Integer id, @RequestBody UserEntity entityRequest) {
        UserEntity entity = userRepo.findById(id).orElseThrow();
        entity.setUsername(entityRequest.getUsername());
        entity.setPassword(entityRequest.getPassword());
        entity.setFullName(entityRequest.getFullName());
        userRepo.save(entity);

        return entity;
    }

    @DeleteMapping("/{id}")
    public UserEntity delete(@PathVariable Integer id) {
        UserEntity entity = userRepo.findById(id).orElseThrow();
        userRepo.delete(entity);

        return entity;
    }

}
