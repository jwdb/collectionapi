package dev.janwillem.collectionapi.dataAccess.repository;

import dev.janwillem.collectionapi.dataAccess.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderLineRepository extends JpaRepository<OrderLine, UUID> {
}
