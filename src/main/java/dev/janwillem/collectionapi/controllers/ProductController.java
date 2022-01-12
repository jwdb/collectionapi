package dev.janwillem.collectionapi.controllers;

import dev.janwillem.collectionapi.dataAccess.dao.ProductDAO;
import dev.janwillem.collectionapi.dataAccess.models.Product;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductDAO repository;


    @GetMapping("")
    @PreAuthorize("permitAll()")
    public List<Product> getHandler() {
        return new ArrayList<>(repository.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getHandler(@PathVariable String id) {
        var uuid = UUID.fromString(id);
        var obj = repository.findById(uuid);

        if (obj.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>((Product) Hibernate.unproxy(obj.get()), HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public ResponseEntity<UUID> postHandler(@RequestBody Product postRequest) {
        var nItem = repository.saveToDatabase(postRequest);

        return new ResponseEntity<>(nItem.getId(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public ResponseEntity<Product> putHandler(@PathVariable String id, @RequestBody Product postRequest) {
        var uuid = UUID.fromString(id);
        var dbo = repository.findById(uuid);

        if (!postRequest.getId().equals(uuid) || dbo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var nItem = repository.saveToDatabase(postRequest);

        return new ResponseEntity<>(nItem, HttpStatus.OK);
    }
}
