package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.Address;
import dev.janwillem.collectionapi.dataAccess.repository.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AddressDAO {
    private final AddressRepository addressRepository;

    public AddressDAO(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> findById(UUID id) {
        return this.addressRepository.findById(id);
    }
    public Optional<Address> findByUserId(UUID id) {
        return this.addressRepository.findByUserId(id);
    }

    public Address saveToDatabase(Address address) {
        return this.addressRepository.save(address);
    }
}
