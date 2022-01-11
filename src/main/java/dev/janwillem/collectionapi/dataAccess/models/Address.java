package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Address {
    @Id
    private UUID Id;
    private UUID UserId;
    private String Street;
    private String ZIP;
    private String City;

    public UUID getId() {
        return Id;
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Address() {

    }

    public Address(UUID userId, String street, String ZIP, String city) {
        UserId = userId;
        Street = street;
        this.ZIP = ZIP;
        City = city;
    }
}
