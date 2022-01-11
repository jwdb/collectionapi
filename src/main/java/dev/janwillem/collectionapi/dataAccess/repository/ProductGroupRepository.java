package dev.janwillem.collectionapi.dataAccess.repository;

import dev.janwillem.collectionapi.dataAccess.models.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, UUID> {
}
