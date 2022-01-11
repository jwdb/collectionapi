package dev.janwillem.collectionapi.dataAccess.repository;

import dev.janwillem.collectionapi.dataAccess.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
