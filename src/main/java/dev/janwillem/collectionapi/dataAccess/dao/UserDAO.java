package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.User;
import dev.janwillem.collectionapi.dataAccess.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDAO {
    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(UUID id) {
        return this.userRepository.findById(id);
    }

    public User saveToDatabase(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
