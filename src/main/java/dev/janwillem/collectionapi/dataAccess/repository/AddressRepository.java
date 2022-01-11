package dev.janwillem.collectionapi.dataAccess.repository;

import dev.janwillem.collectionapi.dataAccess.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
