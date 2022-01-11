package dev.janwillem.collectionapi.dataAccess.repository;

import dev.janwillem.collectionapi.dataAccess.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
