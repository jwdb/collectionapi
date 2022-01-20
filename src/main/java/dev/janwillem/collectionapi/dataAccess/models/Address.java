package dev.janwillem.collectionapi.dataAccess.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID userId;
    private String street;
    private String ZIP;
    private String city;

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address() {

    }

    public Address(UUID userId, String street, String ZIP, String city) {
        this.userId = userId;
        this.street = street;
        this.ZIP = ZIP;
        this.city = city;
    }
}
