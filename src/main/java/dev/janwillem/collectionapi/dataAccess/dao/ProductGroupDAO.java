package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.ProductGroup;
import dev.janwillem.collectionapi.dataAccess.repository.ProductGroupRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductGroupDAO {
    private final ProductGroupRepository productGroupRepository;

    public ProductGroupDAO(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    public Optional<ProductGroup> findById(UUID id) {
        return this.productGroupRepository.findById(id);
    }

    public ProductGroup saveToDatabase(ProductGroup productGroup) {
        return this.productGroupRepository.save(productGroup);
    }

    public List<ProductGroup> getAll() {
        return this.productGroupRepository.findAll();
    }
}
