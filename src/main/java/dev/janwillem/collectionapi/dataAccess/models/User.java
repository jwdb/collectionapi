package dev.janwillem.collectionapi.dataAccess.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;
@Entity
public class User {
    @Id
    private UUID id;
    private String Name;
    private String Password;
    private Instant CreateDate;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Instant getCreateDate() {
        return CreateDate;
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public User(String name) {
        Name = name;
    }

    public User() {

    }
}
