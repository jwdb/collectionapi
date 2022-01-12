package dev.janwillem.collectionapi.dataAccess.dao;

import dev.janwillem.collectionapi.dataAccess.models.Address;
import dev.janwillem.collectionapi.dataAccess.repository.AddressRepository;

import java.util.Optional;
import java.util.UUID;

public class AddressDAO {
    private final AddressRepository addressRepository;

    public AddressDAO(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> findById(UUID id) {
        return this.addressRepository.findById(id);
    }

    public Address saveToDatabase(Address address) {
        return this.addressRepository.save(address);
    }
}
