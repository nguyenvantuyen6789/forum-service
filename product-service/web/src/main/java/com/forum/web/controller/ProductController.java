package com.forum.web.controller;

import com.forum.domain.ProductEntity;
import com.forum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public List<ProductEntity> get() {
        List<ProductEntity> productEntities = productRepo.findAll();

        return productEntities;
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity entityRequest) {
        productRepo.save(entityRequest);

        return entityRequest;
    }

    @PutMapping("/{id}")
    public ProductEntity update(@PathVariable Integer id, @RequestBody ProductEntity entityRequest) {
        ProductEntity entity = productRepo.findById(id).orElseThrow();
        entity.setProductName(entityRequest.getProductName());
        productRepo.save(entity);

        return entity;
    }

    @DeleteMapping("/{id}")
    public ProductEntity delete(@PathVariable Integer id) {
        ProductEntity entity = productRepo.findById(id).orElseThrow();
        productRepo.delete(entity);

        return entity;
    }

}
